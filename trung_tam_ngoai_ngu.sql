-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 06, 2022 lúc 04:40 PM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `trung_tam_ngoai_ngu`
--

DELIMITER $$
--
-- Thủ tục
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_insert_thisinhduthi` (IN `cmnd` VARCHAR(12), IN `matrinhdo` INT(8), IN `makhoathi` INT(8))  BEGIN
  DECLARE tenTrinhDo varchar(50); DECLARE tenPhong varchar(50); DECLARE maPhong int(8); DECLARE maChamThi int(8); DECLARE maCanhThi int(8); DECLARE baiThi int(8); DECLARE sbd varchar(10); DECLARE soLuong int(8);
  SET tenTrinhDo = (
      SELECT TD.tenTrinhDo
      FROM trinhdo TD
      WHERE TD.maTrinhDo = matrinhdo
  ) ;
  IF (makhoathi not in (
      SELECT PT.maKhoaThi
      FROM phongthi PT
      WHERE PT.maKhoaThi = makhoathi AND PT.maTrinhDo = matrinhdo
  )) THEN
      BEGIN
          SET tenPhong = (SELECT CONCAT(tenTrinhDo, "P", right(concat('000', '1'),3)));
          INSERT INTO `phongthi`(`maKhoaThi`, `maTrinhDo`, `tenPhongThi`) VALUES (makhoathi,matrinhdo, tenphong);
          
          set maPhong = (
              SELECT MAX(PT.maPhongThi)
              FROM phongthi PT
          );
          INSERT INTO `chamthi`() VALUES ();
          INSERT INTO `canhthi`() VALUES ();
          
          SET maChamThi = (
              SELECT MAX(`chamthi`.`maChamThi`)
              FROM `chamthi`
          );
          SET maCanhThi = (
              SELECT MAX(`canhthi`.`maCanhThi`)
              FROM `canhthi`
          );
          INSERT INTO `baithi`(`maCanhThi`, `maChamThi`) VALUES (maCanhThi,maChamThi);
          
          SET baiThi = (
              SELECT MAX(`baithi`.`maBaiThi`)
              FROM `baithi`
          );
          SET sbd = (
              SELECT CONCAT(tenTrinhDo, right(concat('000', COUNT(TSDT.maThiSinh) + 1),3))
              FROM thisinhduthi TSDT, phongthi PT
              WHERE PT.maPhongThi = TSDT.maPhongThi AND PT.maKhoaThi = makhoathi AND PT.maTrinhDo = matrinhdo
          );
          INSERT INTO `thisinhduthi`(`cmnd`, `maPhongThi`, `maBaiThi`, `sbd`) VALUES (cmnd, maPhong, baiThi, sbd);
      END;
  ELSE
      BEGIN
          SET maPhong = (
              SELECT MAX(PT.maPhongThi)
              FROM phongthi PT
              WHERE PT.maKhoaThi = makhoathi AND PT.maTrinhDo = matrinhdo
          );
          IF (35 <= (
              SELECT COUNT(TSDT.cmnd)
              FROM thisinhduthi TSDT
              WHERE TSDT.maPhongThi = maPhong
              )) THEN
              BEGIN
                  
                  SET soLuong = (
                      SELECT COUNT(PT.maPhongThi)
                      FROM phongthi PT
                      WHERE PT.maKhoaThi = makhoathi AND PT.maTrinhDo = matrinhdo
                  );
                  SET tenPhong = (
                      SELECT CONCAT(TD.tenTrinhDo, "P", right(concat('000', soLuong + 1),3))
                      FROM trinhdo TD
                      WHERE TD.maTrinhDo = matrinhdo
                  );
                  INSERT INTO `phongthi`(`maKhoaThi`, `maTrinhDo`, `tenPhongThi`) VALUES (makhoathi, matrinhdo, tenphongThi);
                  set maPhong = (
                      SELECT MAX(PT.maPhongThi)
                      FROM phongthi PT
                  );
                  INSERT INTO `chamthi`() VALUES ();
                  INSERT INTO `canhthi`() VALUES ();
                  SET maChamThi = (
                      SELECT MAX(`chamthi`.`maChamThi`)
                      FROM `chamthi`
                  );
                  SET maCanhThi = (
                      SELECT MAX(`canhthi`.`maCanhThi`)
                      FROM `canhthi`
                  );
                  INSERT INTO `baithi`(`maCanhThi`, `maChamThi`) VALUES (maCanhThi,maChamThi);
                  SET baiThi = (
                      SELECT MAX(`baithi`.`maBaiThi`)
                      FROM `baithi`
                  );
                  SET sbd = (
                      SELECT CONCAT(tenTrinhDo, right(concat('000', COUNT(TSDT.maThiSinh) + 1),3))
                      FROM thisinhduthi TSDT, phongthi PT
                      WHERE PT.maPhongThi = TSDT.maPhongThi AND PT.maKhoaThi = makhoathi AND PT.maTrinhDo = matrinhdo
                  );
                  INSERT INTO `thisinhduthi`(`cmnd`, `maPhongThi`, `maBaiThi`, `sbd`) VALUES (cmnd, maPhong, baiThi, sbd);
              END;
      ELSE  
              BEGIN
                  INSERT INTO `chamthi`() VALUES ();
                  INSERT INTO `canhthi`() VALUES ();
                  SET maChamThi = (
                      SELECT MAX(`chamthi`.`maChamThi`)
                      FROM `chamthi`
                  );
                  SET maCanhThi = (
                      SELECT MAX(`canhthi`.`maCanhThi`)
                      FROM `canhthi`
                  );
                  INSERT INTO `baithi`(`maCanhThi`, `maChamThi`) VALUES (maCanhThi,maChamThi);
                  SET baiThi = (
                      SELECT MAX(`baithi`.`maBaiThi`)
                      FROM `baithi`
                  );
                  SET sbd = (
                      SELECT CONCAT(tenTrinhDo, right(concat('000', COUNT(TSDT.maThiSinh) + 1),3))
                      FROM thisinhduthi TSDT, phongthi PT
                      WHERE PT.maPhongThi = TSDT.maPhongThi AND PT.maKhoaThi = makhoathi AND PT.maTrinhDo = matrinhdo
                  );
                  INSERT INTO `thisinhduthi`(`cmnd`, `maPhongThi`, `maBaiThi`, `sbd`) VALUES (cmnd, maPhong, baiThi, sbd);
              END;
      END IF;
      END ;
END IF;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baithi`
--

CREATE TABLE `baithi` (
  `maBaiThi` int(8) UNSIGNED NOT NULL,
  `maCanhThi` int(8) UNSIGNED NOT NULL,
  `maChamThi` int(8) UNSIGNED NOT NULL,
  `diemNghe` float NOT NULL,
  `diemNoi` float NOT NULL,
  `diemDoc` float NOT NULL,
  `diemViet` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `baithi`
--

INSERT INTO `baithi` (`maBaiThi`, `maCanhThi`, `maChamThi`, `diemNghe`, `diemNoi`, `diemDoc`, `diemViet`) VALUES
(8, 8, 7, 100, 60, 70, 80),
(9, 9, 8, 55, 90, 40, 30),
(10, 10, 9, 0, 0, 0, 0),
(11, 11, 10, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `canhthi`
--

CREATE TABLE `canhthi` (
  `maCanhThi` int(8) UNSIGNED NOT NULL,
  `maGiaoVien1` int(8) UNSIGNED DEFAULT NULL,
  `maGiaoVien2` int(8) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `canhthi`
--

INSERT INTO `canhthi` (`maCanhThi`, `maGiaoVien1`, `maGiaoVien2`) VALUES
(8, NULL, NULL),
(9, NULL, NULL),
(10, NULL, NULL),
(11, NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chamthi`
--

CREATE TABLE `chamthi` (
  `maChamThi` int(8) UNSIGNED NOT NULL,
  `maGiaoVien1` int(8) UNSIGNED DEFAULT NULL,
  `maGiaoVien2` int(8) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chamthi`
--

INSERT INTO `chamthi` (`maChamThi`, `maGiaoVien1`, `maGiaoVien2`) VALUES
(7, NULL, NULL),
(8, NULL, NULL),
(9, NULL, NULL),
(10, NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giaovien`
--

CREATE TABLE `giaovien` (
  `maGiaoVien` int(8) UNSIGNED NOT NULL,
  `tenGiaoVien` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `giaovien`
--

INSERT INTO `giaovien` (`maGiaoVien`, `tenGiaoVien`) VALUES
(1, 'Lê Công Được'),
(2, 'Hoàng Ngọc Thắng'),
(3, 'Lưu Anh Đức');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khoathi`
--

CREATE TABLE `khoathi` (
  `maKhoaThi` int(8) UNSIGNED NOT NULL,
  `tenKhoaThi` varchar(50) NOT NULL,
  `ngayThi` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `khoathi`
--

INSERT INTO `khoathi` (`maKhoaThi`, `tenKhoaThi`, `ngayThi`) VALUES
(3, 'Khóa 1 2022', '2022-01-30'),
(4, 'Khóa 3 2022', '2022-03-30'),
(6, 'Khóa 2 2020', '2022-01-08');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phongthi`
--

CREATE TABLE `phongthi` (
  `maPhongThi` int(8) UNSIGNED NOT NULL,
  `maKhoaThi` int(8) UNSIGNED NOT NULL,
  `maTrinhDo` int(8) UNSIGNED NOT NULL,
  `tenPhongThi` varchar(50) NOT NULL,
  `caThi` int(4) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `phongthi`
--

INSERT INTO `phongthi` (`maPhongThi`, `maKhoaThi`, `maTrinhDo`, `tenPhongThi`, `caThi`) VALUES
(6, 3, 1, 'A2P001', 1),
(10, 3, 2, 'B1P001', 1),
(11, 4, 2, 'B1P002', 1),
(12, 6, 1, 'A2P002', 1),
(13, 4, 1, 'A2P001', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thisinh`
--

CREATE TABLE `thisinh` (
  `cmnd` varchar(12) NOT NULL,
  `ho` varchar(50) NOT NULL,
  `ten` varchar(50) NOT NULL,
  `gioiTinh` varchar(10) NOT NULL DEFAULT 'Nam',
  `ngaySinh` date NOT NULL,
  `noiSinh` varchar(100) NOT NULL DEFAULT 'N''Hồ Chí Minh''',
  `ngayCap` date NOT NULL,
  `noiCap` varchar(100) NOT NULL DEFAULT 'N''Hồ Chí Minh''',
  `sdt` varchar(12) NOT NULL,
  `email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `thisinh`
--

INSERT INTO `thisinh` (`cmnd`, `ho`, `ten`, `gioiTinh`, `ngaySinh`, `noiSinh`, `ngayCap`, `noiCap`, `sdt`, `email`) VALUES
('123456789', 'Hoàng Ngọc', 'Thắng', 'Nam', '2000-01-05', 'Hồ Chí Minh', '2022-01-05', 'Hồ Chí Minh', '0123456789', 'thang@gmail.com'),
('221442360', 'Lê Công', 'Được', 'Nam', '1997-11-19', 'Phú Yên', '2015-01-05', 'Phú Yên', '0868521234', 'congduocpy97@gmail.com'),
('261419950', 'Nguyễn', 'Minh Thiện', 'Nam', '2000-01-06', 'Bến Tre', '2022-01-07', 'Bến Tre', '0824264181', 'luuanhduc19@gmail.com'),
('261419951', 'Lưu', 'Anh Đức', 'Nam', '1999-12-05', 'Bình Thuận', '2019-01-02', 'Bình Thuận', '0824264195', 'luuanhduc19@gmail.com'),
('261419956', 'Lưu ', 'Anh Duy', 'Nam', '2000-01-04', 'Bình Thuận', '2021-10-01', 'Bình Thuận', '0824264191', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thisinhduthi`
--

CREATE TABLE `thisinhduthi` (
  `maThiSinh` int(8) UNSIGNED NOT NULL,
  `cmnd` varchar(12) NOT NULL,
  `maPhongThi` int(8) UNSIGNED NOT NULL,
  `maBaiThi` int(8) UNSIGNED NOT NULL,
  `sbd` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `thisinhduthi`
--

INSERT INTO `thisinhduthi` (`maThiSinh`, `cmnd`, `maPhongThi`, `maBaiThi`, `sbd`) VALUES
(2, '221442360', 6, 8, 'A2001'),
(3, '123456789', 10, 9, 'B1001'),
(4, '261419950', 11, 10, 'B1001');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `trinhdo`
--

CREATE TABLE `trinhdo` (
  `maTrinhDo` int(8) UNSIGNED NOT NULL,
  `tenTrinhDo` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `trinhdo`
--

INSERT INTO `trinhdo` (`maTrinhDo`, `tenTrinhDo`) VALUES
(1, 'A2'),
(2, 'B1');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `baithi`
--
ALTER TABLE `baithi`
  ADD PRIMARY KEY (`maBaiThi`),
  ADD KEY `FK` (`maCanhThi`,`maChamThi`) USING BTREE,
  ADD KEY `maChamThi` (`maChamThi`);

--
-- Chỉ mục cho bảng `canhthi`
--
ALTER TABLE `canhthi`
  ADD PRIMARY KEY (`maCanhThi`),
  ADD KEY `maGiaoVien1` (`maGiaoVien1`,`maGiaoVien2`),
  ADD KEY `maGiaoVien2` (`maGiaoVien2`);

--
-- Chỉ mục cho bảng `chamthi`
--
ALTER TABLE `chamthi`
  ADD PRIMARY KEY (`maChamThi`),
  ADD KEY `maGiaoVien1` (`maGiaoVien1`,`maGiaoVien2`) USING BTREE,
  ADD KEY `maGiaoVien2` (`maGiaoVien2`);

--
-- Chỉ mục cho bảng `giaovien`
--
ALTER TABLE `giaovien`
  ADD PRIMARY KEY (`maGiaoVien`);

--
-- Chỉ mục cho bảng `khoathi`
--
ALTER TABLE `khoathi`
  ADD PRIMARY KEY (`maKhoaThi`);

--
-- Chỉ mục cho bảng `phongthi`
--
ALTER TABLE `phongthi`
  ADD PRIMARY KEY (`maPhongThi`),
  ADD KEY `FK` (`maKhoaThi`,`maTrinhDo`),
  ADD KEY `maTrinhDo` (`maTrinhDo`);

--
-- Chỉ mục cho bảng `thisinh`
--
ALTER TABLE `thisinh`
  ADD PRIMARY KEY (`cmnd`);

--
-- Chỉ mục cho bảng `thisinhduthi`
--
ALTER TABLE `thisinhduthi`
  ADD PRIMARY KEY (`maThiSinh`),
  ADD KEY `FK` (`cmnd`,`maPhongThi`,`maBaiThi`),
  ADD KEY `maPhongThi` (`maPhongThi`),
  ADD KEY `maBaiThi` (`maBaiThi`);

--
-- Chỉ mục cho bảng `trinhdo`
--
ALTER TABLE `trinhdo`
  ADD PRIMARY KEY (`maTrinhDo`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `baithi`
--
ALTER TABLE `baithi`
  MODIFY `maBaiThi` int(8) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `canhthi`
--
ALTER TABLE `canhthi`
  MODIFY `maCanhThi` int(8) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `chamthi`
--
ALTER TABLE `chamthi`
  MODIFY `maChamThi` int(8) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `giaovien`
--
ALTER TABLE `giaovien`
  MODIFY `maGiaoVien` int(8) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `khoathi`
--
ALTER TABLE `khoathi`
  MODIFY `maKhoaThi` int(8) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `phongthi`
--
ALTER TABLE `phongthi`
  MODIFY `maPhongThi` int(8) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT cho bảng `thisinhduthi`
--
ALTER TABLE `thisinhduthi`
  MODIFY `maThiSinh` int(8) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `trinhdo`
--
ALTER TABLE `trinhdo`
  MODIFY `maTrinhDo` int(8) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `baithi`
--
ALTER TABLE `baithi`
  ADD CONSTRAINT `baithi_ibfk_1` FOREIGN KEY (`maChamThi`) REFERENCES `chamthi` (`maChamThi`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `baithi_ibfk_2` FOREIGN KEY (`maCanhThi`) REFERENCES `canhthi` (`maCanhThi`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `canhthi`
--
ALTER TABLE `canhthi`
  ADD CONSTRAINT `canhthi_ibfk_1` FOREIGN KEY (`maGiaoVien1`) REFERENCES `giaovien` (`maGiaoVien`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `canhthi_ibfk_2` FOREIGN KEY (`maGiaoVien2`) REFERENCES `giaovien` (`maGiaoVien`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `chamthi`
--
ALTER TABLE `chamthi`
  ADD CONSTRAINT `chamthi_ibfk_1` FOREIGN KEY (`maGiaoVien1`) REFERENCES `giaovien` (`maGiaoVien`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `chamthi_ibfk_2` FOREIGN KEY (`maGiaoVien2`) REFERENCES `giaovien` (`maGiaoVien`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `phongthi`
--
ALTER TABLE `phongthi`
  ADD CONSTRAINT `phongthi_ibfk_1` FOREIGN KEY (`maTrinhDo`) REFERENCES `trinhdo` (`maTrinhDo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `phongthi_ibfk_2` FOREIGN KEY (`maKhoaThi`) REFERENCES `khoathi` (`maKhoaThi`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `thisinhduthi`
--
ALTER TABLE `thisinhduthi`
  ADD CONSTRAINT `thisinhduthi_ibfk_1` FOREIGN KEY (`cmnd`) REFERENCES `thisinh` (`cmnd`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `thisinhduthi_ibfk_2` FOREIGN KEY (`maPhongThi`) REFERENCES `phongthi` (`maPhongThi`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `thisinhduthi_ibfk_3` FOREIGN KEY (`maBaiThi`) REFERENCES `baithi` (`maBaiThi`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
