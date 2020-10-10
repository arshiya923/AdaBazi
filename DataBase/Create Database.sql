-- --------------------------------------------------------
-- Host:                         C:\Users\Arshiya\Desktop\Github\AdaBazi\DataBase\AdaBazi.db
-- Server version:               3.30.1
-- Server OS:                    
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES  */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for main
CREATE DATABASE IF NOT EXISTS "main";
USE "main";

-- Dumping structure for table main.Category
CREATE TABLE IF NOT EXISTS "Category" (
	"id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	"name"	TEXT NOT NULL UNIQUE
);

-- Data exporting was unselected.

-- Dumping structure for table main.Game
CREATE TABLE IF NOT EXISTS "Game" (
	"id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	"gameround_id"	INTEGER NOT NULL,
	"team_id"	INTEGER,
	"result"	TEXT,
	FOREIGN KEY("gameround_id") REFERENCES "GameRound"("id"),
	FOREIGN KEY("team_id") REFERENCES "TeamName"("id")
);

-- Data exporting was unselected.

-- Dumping structure for table main.GameRound
CREATE TABLE IF NOT EXISTS "GameRound" (
	"id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	"time_id"	INTEGER NOT NULL,
	"gametype_id"	INTEGER NOT NULL,
	"word_id"	INTEGER NOT NULL,
	FOREIGN KEY("time_id") REFERENCES "Time"("id"),
	FOREIGN KEY("gametype_id") REFERENCES "GameType"("id"),
	FOREIGN KEY("word_id") REFERENCES "Word"("id")
);

-- Data exporting was unselected.

-- Dumping structure for table main.GameType
CREATE TABLE IF NOT EXISTS "GameType" (
	"id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	"name"	TEXT NOT NULL UNIQUE
);

-- Data exporting was unselected.

-- Dumping structure for table main.TeamName
CREATE TABLE IF NOT EXISTS "TeamName" (
	"id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	"name"	TEXT NOT NULL UNIQUE
);

-- Data exporting was unselected.

-- Dumping structure for table main.Time
CREATE TABLE IF NOT EXISTS "Time" (
	"id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	"name"	TEXT NOT NULL UNIQUE,
	"duration"	INTEGER NOT NULL
);

-- Data exporting was unselected.

-- Dumping structure for table main.Word
CREATE TABLE IF NOT EXISTS "Word" (
	"id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	"name"	TEXT NOT NULL UNIQUE,
	"catagory_id"	INTEGER NOT NULL,
	FOREIGN KEY("catagory_id") REFERENCES "Category"("id")
);

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
