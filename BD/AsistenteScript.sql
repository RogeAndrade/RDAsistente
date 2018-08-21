USE [master]
GO
/****** Object:  Database [asistente]    Script Date: 19/08/2018 11:41:00 p. m. ******/
CREATE DATABASE [asistente]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'asistente', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\asistente.mdf' , SIZE = 4160KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'asistente_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\asistente_log.ldf' , SIZE = 1040KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [asistente] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [asistente].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [asistente] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [asistente] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [asistente] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [asistente] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [asistente] SET ARITHABORT OFF 
GO
ALTER DATABASE [asistente] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [asistente] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [asistente] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [asistente] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [asistente] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [asistente] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [asistente] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [asistente] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [asistente] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [asistente] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [asistente] SET  ENABLE_BROKER 
GO
ALTER DATABASE [asistente] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [asistente] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [asistente] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [asistente] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [asistente] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [asistente] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [asistente] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [asistente] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [asistente] SET  MULTI_USER 
GO
ALTER DATABASE [asistente] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [asistente] SET DB_CHAINING OFF 
GO
ALTER DATABASE [asistente] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [asistente] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [asistente]
GO
/****** Object:  StoredProcedure [dbo].[sp_register_user]    Script Date: 19/08/2018 11:41:00 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[sp_register_user] (@nombre varchar(50), @apellidos varchar(120), @telefono varchar(15), @correo varchar(150), @url_img varchar(255), 
@usr varchar(40), @psw varchar(20), @facebook char(1), @google char(1), @mail char(1), @ret int output)
as
begin
declare @transactiosActive int;
set @transactiosActive = (SELECT @@trancount);
if(@transactiosActive > 0)
begin
save transaction addUser
end
else
begin
begin transaction addUser
end
declare @valUser tinyint;
set @valUser = (select COUNT(*) from tbl_usuario where usr = @usr);
if(@valUser>0)
begin
set @ret = -4;
rollback transaction addUser;
return;
end
declare @valCorreo tinyint;
set @valCorreo = (select COUNT(*) from tbl_persona where correo = @correo);
if(@valCorreo>0)
begin
set @ret = -5;
rollback transaction addUser;
return;
end
declare @countRegisterBef int;
declare @countRegisterAft int;
declare @countUserBef int;
declare @countUserAft int;
declare @idPersona int;
declare @idUsuario int;
set @countRegisterBef = (select COUNT(*) from tbl_persona);
set @countUserBef = (select COUNT(*) from tbl_persona);
if(@countRegisterBef is null)
begin
set @countRegisterBef = 0;
end
if(@countUserBef is null)
begin
set @countUserBef = 0;
end
insert into tbl_persona values(@nombre, @apellidos, @telefono, @correo, @url_img);
set @countRegisterAft = (select COUNT(*) from tbl_persona);
if(@countRegisterAft is null)
begin
set @ret = -1;
rollback transaction addUser;
return;
end
else
begin
if(@countRegisterBef<@countRegisterAft)
begin
set @idPersona = (select MAX(id) from tbl_persona);
if(@idPersona is not null and @idPersona > 0)
begin
insert into tbl_usuario values(@idPersona, HASHBYTES('SHA2_256',@psw), @usr, @facebook, @google, @mail, HASHBYTES('SHA2_256','RDAsistenteSYS2018#$853'), 1);
set @countUserAft = (select COUNT(*) from tbl_persona)
if(@countUserBef<@countRegisterAft)
begin
set @idUsuario = (select MAX(id) from tbl_usuario);
if(@idUsuario is not null and @idUsuario>0)
begin
set @ret = @idUsuario;
--set @transactiosActive = (SELECT @@trancount);
--if(@transactiosActive > 0)
--begin
--commit transaction addUser;
--end
return;
end
else
begin
set @ret = -3;
rollback transaction addUser;
return;
end
end
else
begin
set @ret = -3;
rollback transaction addUser;
return;
end
end
else
begin
set @ret = -2;
rollback transaction addUser;
return;
end
end
else
begin
set @ret = -1;
rollback transaction addUser;
return;
end
end
set @transactiosActive = (SELECT @@trancount);
if(@transactiosActive > 0)
begin
commit transaction addUser;
end
end
GO
/****** Object:  Table [dbo].[tbl_persona]    Script Date: 19/08/2018 11:41:00 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_persona](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[apellidos] [varchar](120) NULL,
	[telefono] [varchar](15) NOT NULL,
	[correo] [varchar](150) NOT NULL,
	[url_img] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbl_usuario]    Script Date: 19/08/2018 11:41:00 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_usuario](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_persona] [int] NOT NULL,
	[psw] [varchar](255) NOT NULL,
	[usr] [varchar](40) NOT NULL,
	[facebook] [char](1) NOT NULL,
	[google] [char](1) NOT NULL,
	[mail] [char](1) NOT NULL,
	[alter_pass] [varchar](255) NOT NULL,
	[recibe_notificaciones] [char](1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[tbl_usuario]  WITH CHECK ADD FOREIGN KEY([id_persona])
REFERENCES [dbo].[tbl_persona] ([id])
GO
USE [master]
GO
ALTER DATABASE [asistente] SET  READ_WRITE 
GO
