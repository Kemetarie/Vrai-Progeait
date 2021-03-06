USE [master]
GO
/****** Object:  Database [progeait]    Script Date: 15/10/2018 14:42:13 ******/
CREATE DATABASE [progeait]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'progeait', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\progeait.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'progeait_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\progeait_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [progeait] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [progeait].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [progeait] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [progeait] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [progeait] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [progeait] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [progeait] SET ARITHABORT OFF 
GO
ALTER DATABASE [progeait] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [progeait] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [progeait] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [progeait] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [progeait] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [progeait] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [progeait] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [progeait] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [progeait] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [progeait] SET  DISABLE_BROKER 
GO
ALTER DATABASE [progeait] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [progeait] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [progeait] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [progeait] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [progeait] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [progeait] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [progeait] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [progeait] SET RECOVERY FULL 
GO
ALTER DATABASE [progeait] SET  MULTI_USER 
GO
ALTER DATABASE [progeait] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [progeait] SET DB_CHAINING OFF 
GO
ALTER DATABASE [progeait] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [progeait] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [progeait] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'progeait', N'ON'
GO
USE [progeait]
GO
/****** Object:  Table [dbo].[candidats]    Script Date: 15/10/2018 14:42:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[candidats](
	[idCandidat] [int] IDENTITY(1,1) NOT NULL,
	[codePromotion] [int] NULL,
	[idEpreuve] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idCandidat] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[collaborateurs]    Script Date: 15/10/2018 14:42:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[collaborateurs](
	[idCollaborateur] [int] IDENTITY(1,1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idCollaborateur] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[epreuves]    Script Date: 15/10/2018 14:42:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[epreuves](
	[idEpreuve] [int] IDENTITY(1,1) NOT NULL,
	[dateDebutValidite] [datetime] NOT NULL,
	[dateFinValidite] [datetime] NOT NULL,
	[tempsEcoule] [time](7) NULL,
	[etat] [varchar](250) NOT NULL,
	[note_obtenue] [decimal](18, 0) NULL,
	[niveau_obtenu] [varchar](250) NULL,
PRIMARY KEY CLUSTERED 
(
	[idEpreuve] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[profils]    Script Date: 15/10/2018 14:42:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[profils](
	[codeProfil] [int] IDENTITY(1,1) NOT NULL,
	[libelle] [varchar](250) NOT NULL,
 CONSTRAINT [PK_profil] PRIMARY KEY CLUSTERED 
(
	[codeProfil] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[promotions]    Script Date: 15/10/2018 14:42:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[promotions](
	[codePromo] [int] IDENTITY(1,1) NOT NULL,
	[libelle] [varchar](250) NOT NULL,
 CONSTRAINT [PK_promotion] PRIMARY KEY CLUSTERED 
(
	[codePromo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[propositions]    Script Date: 15/10/2018 14:42:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[propositions](
	[idProposition] [int] IDENTITY(1,1) NOT NULL,
	[enonce] [varchar](250) NOT NULL,
	[estBonne] [bit] NOT NULL,
	[idQuestion] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idProposition] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[question_Tirage]    Script Date: 15/10/2018 14:42:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[question_Tirage](
	[idEpreuve] [int] NOT NULL,
	[idQuestion] [int] NOT NULL,
	[estMarquee] [bit] NOT NULL,
	[numOrdre] [int] NOT NULL,
	[idQuestion_Tirage] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idQuestion_Tirage] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[idEpreuve] ASC,
	[idQuestion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[questions]    Script Date: 15/10/2018 14:42:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[questions](
	[idQuestion] [int] IDENTITY(1,1) NOT NULL,
	[enonce] [varchar](250) NOT NULL,
	[media] [binary](1) NULL,
	[points] [int] NOT NULL,
	[idTheme] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idQuestion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[reponse_Tirage]    Script Date: 15/10/2018 14:42:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[reponse_Tirage](
	[idQuestion_Tirage] [int] NOT NULL,
	[idProposition] [int] NOT NULL,
 CONSTRAINT [PK_reponse_Tirage] PRIMARY KEY CLUSTERED 
(
	[idQuestion_Tirage] ASC,
	[idProposition] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[sections_Test]    Script Date: 15/10/2018 14:42:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sections_Test](
	[idSectionTest] [int] IDENTITY(1,1) NOT NULL,
	[nbQuestionATirer] [int] NOT NULL,
	[idTest] [int] NULL,
	[idTheme] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idSectionTest] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tests]    Script Date: 15/10/2018 14:42:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tests](
	[idTest] [int] IDENTITY(1,1) NOT NULL,
	[libelle] [varchar](250) NOT NULL,
	[description] [varchar](250) NOT NULL,
	[duree] [time](7) NOT NULL,
	[seuil_haut] [varchar](250) NOT NULL,
	[seuil_bas] [varchar](250) NOT NULL,
	[idEpreuve] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idTest] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[themes]    Script Date: 15/10/2018 14:42:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[themes](
	[idTheme] [int] IDENTITY(1,1) NOT NULL,
	[libelle] [varchar](250) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idTheme] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[utilisateurs]    Script Date: 15/10/2018 14:42:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[utilisateurs](
	[idUtilisateur] [int] IDENTITY(1,1) NOT NULL,
	[nom] [varchar](250) NOT NULL,
	[prenom] [varchar](250) NOT NULL,
	[email] [varchar](250) NOT NULL,
	[motDePasse] [varchar](250) NOT NULL,
	[codeProfil] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idUtilisateur] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [email] UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UN_Email] UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[candidats]  WITH CHECK ADD  CONSTRAINT [FK_candidats_epreuves] FOREIGN KEY([idEpreuve])
REFERENCES [dbo].[epreuves] ([idEpreuve])
GO
ALTER TABLE [dbo].[candidats] CHECK CONSTRAINT [FK_candidats_epreuves]
GO
ALTER TABLE [dbo].[candidats]  WITH CHECK ADD  CONSTRAINT [FK_candidats_promotions] FOREIGN KEY([codePromotion])
REFERENCES [dbo].[promotions] ([codePromo])
GO
ALTER TABLE [dbo].[candidats] CHECK CONSTRAINT [FK_candidats_promotions]
GO
ALTER TABLE [dbo].[candidats]  WITH CHECK ADD  CONSTRAINT [FK_candidats_utilisateurs] FOREIGN KEY([idCandidat])
REFERENCES [dbo].[utilisateurs] ([idUtilisateur])
GO
ALTER TABLE [dbo].[candidats] CHECK CONSTRAINT [FK_candidats_utilisateurs]
GO
ALTER TABLE [dbo].[propositions]  WITH CHECK ADD  CONSTRAINT [FK_propositions_questions] FOREIGN KEY([idQuestion])
REFERENCES [dbo].[questions] ([idQuestion])
GO
ALTER TABLE [dbo].[propositions] CHECK CONSTRAINT [FK_propositions_questions]
GO
ALTER TABLE [dbo].[question_Tirage]  WITH CHECK ADD  CONSTRAINT [FK_question_Tirage_epreuves] FOREIGN KEY([idEpreuve])
REFERENCES [dbo].[epreuves] ([idEpreuve])
GO
ALTER TABLE [dbo].[question_Tirage] CHECK CONSTRAINT [FK_question_Tirage_epreuves]
GO
ALTER TABLE [dbo].[question_Tirage]  WITH CHECK ADD  CONSTRAINT [FK_question_Tirage_questions] FOREIGN KEY([idQuestion])
REFERENCES [dbo].[questions] ([idQuestion])
GO
ALTER TABLE [dbo].[question_Tirage] CHECK CONSTRAINT [FK_question_Tirage_questions]
GO
ALTER TABLE [dbo].[questions]  WITH CHECK ADD  CONSTRAINT [FK_questions_themes] FOREIGN KEY([idTheme])
REFERENCES [dbo].[themes] ([idTheme])
GO
ALTER TABLE [dbo].[questions] CHECK CONSTRAINT [FK_questions_themes]
GO
ALTER TABLE [dbo].[reponse_Tirage]  WITH CHECK ADD  CONSTRAINT [FK_reponse_Tirage_propositions] FOREIGN KEY([idProposition])
REFERENCES [dbo].[propositions] ([idProposition])
GO
ALTER TABLE [dbo].[reponse_Tirage] CHECK CONSTRAINT [FK_reponse_Tirage_propositions]
GO
ALTER TABLE [dbo].[reponse_Tirage]  WITH CHECK ADD  CONSTRAINT [FK_reponse_Tirage_question_Tirage] FOREIGN KEY([idQuestion_Tirage])
REFERENCES [dbo].[question_Tirage] ([idQuestion_Tirage])
GO
ALTER TABLE [dbo].[reponse_Tirage] CHECK CONSTRAINT [FK_reponse_Tirage_question_Tirage]
GO
ALTER TABLE [dbo].[sections_Test]  WITH CHECK ADD  CONSTRAINT [FK_sections_Test_tests] FOREIGN KEY([idTest])
REFERENCES [dbo].[tests] ([idTest])
GO
ALTER TABLE [dbo].[sections_Test] CHECK CONSTRAINT [FK_sections_Test_tests]
GO
ALTER TABLE [dbo].[sections_Test]  WITH CHECK ADD  CONSTRAINT [FK_sections_Test_themes] FOREIGN KEY([idTheme])
REFERENCES [dbo].[themes] ([idTheme])
GO
ALTER TABLE [dbo].[sections_Test] CHECK CONSTRAINT [FK_sections_Test_themes]
GO
ALTER TABLE [dbo].[tests]  WITH CHECK ADD  CONSTRAINT [FK_tests_epreuves] FOREIGN KEY([idEpreuve])
REFERENCES [dbo].[epreuves] ([idEpreuve])
GO
ALTER TABLE [dbo].[tests] CHECK CONSTRAINT [FK_tests_epreuves]
GO
ALTER TABLE [dbo].[utilisateurs]  WITH CHECK ADD  CONSTRAINT [FK_utilisateurs_profils] FOREIGN KEY([codeProfil])
REFERENCES [dbo].[profils] ([codeProfil])
GO
ALTER TABLE [dbo].[utilisateurs] CHECK CONSTRAINT [FK_utilisateurs_profils]
GO
USE [master]
GO
ALTER DATABASE [progeait] SET  READ_WRITE 
GO
