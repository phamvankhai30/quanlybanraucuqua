-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 23, 2022 lúc 11:28 PM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `phpmyadmin`
--
CREATE DATABASE IF NOT EXISTS `phpmyadmin` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `phpmyadmin`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__bookmark`
--

CREATE TABLE `pma__bookmark` (
  `id` int(10) UNSIGNED NOT NULL,
  `dbase` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `user` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `label` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `query` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Bookmarks';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__central_columns`
--

CREATE TABLE `pma__central_columns` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_type` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_length` text COLLATE utf8_bin DEFAULT NULL,
  `col_collation` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_isNull` tinyint(1) NOT NULL,
  `col_extra` varchar(255) COLLATE utf8_bin DEFAULT '',
  `col_default` text COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Central list of columns';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__column_info`
--

CREATE TABLE `pma__column_info` (
  `id` int(5) UNSIGNED NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `column_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `comment` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `mimetype` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `input_transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `input_transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Column information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__designer_settings`
--

CREATE TABLE `pma__designer_settings` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `settings_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Settings related to Designer';

--
-- Đang đổ dữ liệu cho bảng `pma__designer_settings`
--

INSERT INTO `pma__designer_settings` (`username`, `settings_data`) VALUES
('root', '{\"snap_to_grid\":\"off\",\"angular_direct\":\"direct\",\"relation_lines\":\"true\"}');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__export_templates`
--

CREATE TABLE `pma__export_templates` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `export_type` varchar(10) COLLATE utf8_bin NOT NULL,
  `template_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `template_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved export templates';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__favorite`
--

CREATE TABLE `pma__favorite` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Favorite tables';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__history`
--

CREATE TABLE `pma__history` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp(),
  `sqlquery` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='SQL history for phpMyAdmin';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__navigationhiding`
--

CREATE TABLE `pma__navigationhiding` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `item_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `item_type` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Hidden items of navigation tree';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__pdf_pages`
--

CREATE TABLE `pma__pdf_pages` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `page_nr` int(10) UNSIGNED NOT NULL,
  `page_descr` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='PDF relation pages for phpMyAdmin';

--
-- Đang đổ dữ liệu cho bảng `pma__pdf_pages`
--

INSERT INTO `pma__pdf_pages` (`db_name`, `page_nr`, `page_descr`) VALUES
('ql_banraucuqua', 1, 'diagram_QLBRCB'),
('ql_banraucuqua', 2, 'diagram_RCB');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__recent`
--

CREATE TABLE `pma__recent` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Recently accessed tables';

--
-- Đang đổ dữ liệu cho bảng `pma__recent`
--

INSERT INTO `pma__recent` (`username`, `tables`) VALUES
('root', '[{\"db\":\"ql_banraucuqua\",\"table\":\"importbills\"},{\"db\":\"ql_banraucuqua\",\"table\":\"importbilldetails\"},{\"db\":\"ql_banraucuqua\",\"table\":\"orders\"},{\"db\":\"ql_banraucuqua\",\"table\":\"products\"},{\"db\":\"ql_banraucuqua\",\"table\":\"orderdetails\"},{\"db\":\"ql_banraucuqua\",\"table\":\"categorys\"},{\"db\":\"ql_banraucuqua\",\"table\":\"users\"},{\"db\":\"ql_banraucuqua\",\"table\":\"providers\"},{\"db\":\"ql_banraucuqua\",\"table\":\"reports\"},{\"db\":\"ql_banraucuqua\",\"table\":\"order\"}]');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__relation`
--

CREATE TABLE `pma__relation` (
  `master_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relation table';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__savedsearches`
--

CREATE TABLE `pma__savedsearches` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `search_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `search_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved searches';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__table_coords`
--

CREATE TABLE `pma__table_coords` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `pdf_page_number` int(11) NOT NULL DEFAULT 0,
  `x` float UNSIGNED NOT NULL DEFAULT 0,
  `y` float UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for phpMyAdmin PDF output';

--
-- Đang đổ dữ liệu cho bảng `pma__table_coords`
--

INSERT INTO `pma__table_coords` (`db_name`, `table_name`, `pdf_page_number`, `x`, `y`) VALUES
('ql_banraucuqua', 'categorys', 1, 449, 468),
('ql_banraucuqua', 'categorys', 2, 579, 440),
('ql_banraucuqua', 'importbilldetails', 2, 859, 28),
('ql_banraucuqua', 'importbills', 2, 852, 237),
('ql_banraucuqua', 'orderdetails', 1, 168, 382),
('ql_banraucuqua', 'orderdetails', 2, 85, 206),
('ql_banraucuqua', 'orders', 1, 174, 30),
('ql_banraucuqua', 'orders', 2, 85, 9),
('ql_banraucuqua', 'products', 1, 683, 339),
('ql_banraucuqua', 'products', 2, 333, 225),
('ql_banraucuqua', 'providers', 1, 391, 228),
('ql_banraucuqua', 'providers', 2, 571, 11),
('ql_banraucuqua', 'reports', 1, 691, 39),
('ql_banraucuqua', 'reports', 2, 581, 175),
('ql_banraucuqua', 'users', 1, 399, 34),
('ql_banraucuqua', 'users', 2, 319, 9);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__table_info`
--

CREATE TABLE `pma__table_info` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `display_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__table_uiprefs`
--

CREATE TABLE `pma__table_uiprefs` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `prefs` text COLLATE utf8_bin NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tables'' UI preferences';

--
-- Đang đổ dữ liệu cho bảng `pma__table_uiprefs`
--

INSERT INTO `pma__table_uiprefs` (`username`, `db_name`, `table_name`, `prefs`, `last_update`) VALUES
('root', 'ql_banraucuqua', 'users', '{\"sorted_col\":\"`users`.`Phone` ASC\"}', '2022-09-30 15:16:19');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__tracking`
--

CREATE TABLE `pma__tracking` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `version` int(10) UNSIGNED NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `schema_snapshot` text COLLATE utf8_bin NOT NULL,
  `schema_sql` text COLLATE utf8_bin DEFAULT NULL,
  `data_sql` longtext COLLATE utf8_bin DEFAULT NULL,
  `tracking` set('UPDATE','REPLACE','INSERT','DELETE','TRUNCATE','CREATE DATABASE','ALTER DATABASE','DROP DATABASE','CREATE TABLE','ALTER TABLE','RENAME TABLE','DROP TABLE','CREATE INDEX','DROP INDEX','CREATE VIEW','ALTER VIEW','DROP VIEW') COLLATE utf8_bin DEFAULT NULL,
  `tracking_active` int(1) UNSIGNED NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Database changes tracking for phpMyAdmin';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__userconfig`
--

CREATE TABLE `pma__userconfig` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `config_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User preferences storage for phpMyAdmin';

--
-- Đang đổ dữ liệu cho bảng `pma__userconfig`
--

INSERT INTO `pma__userconfig` (`username`, `timevalue`, `config_data`) VALUES
('root', '2022-10-23 21:27:58', '{\"Console\\/Mode\":\"collapse\",\"Server\\/hide_db\":\"\",\"Server\\/only_db\":\"\",\"lang\":\"vi\"}');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__usergroups`
--

CREATE TABLE `pma__usergroups` (
  `usergroup` varchar(64) COLLATE utf8_bin NOT NULL,
  `tab` varchar(64) COLLATE utf8_bin NOT NULL,
  `allowed` enum('Y','N') COLLATE utf8_bin NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User groups with configured menu items';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__users`
--

CREATE TABLE `pma__users` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `usergroup` varchar(64) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Users and their assignments to user groups';

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `pma__central_columns`
--
ALTER TABLE `pma__central_columns`
  ADD PRIMARY KEY (`db_name`,`col_name`);

--
-- Chỉ mục cho bảng `pma__column_info`
--
ALTER TABLE `pma__column_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `db_name` (`db_name`,`table_name`,`column_name`);

--
-- Chỉ mục cho bảng `pma__designer_settings`
--
ALTER TABLE `pma__designer_settings`
  ADD PRIMARY KEY (`username`);

--
-- Chỉ mục cho bảng `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_user_type_template` (`username`,`export_type`,`template_name`);

--
-- Chỉ mục cho bảng `pma__favorite`
--
ALTER TABLE `pma__favorite`
  ADD PRIMARY KEY (`username`);

--
-- Chỉ mục cho bảng `pma__history`
--
ALTER TABLE `pma__history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`,`db`,`table`,`timevalue`);

--
-- Chỉ mục cho bảng `pma__navigationhiding`
--
ALTER TABLE `pma__navigationhiding`
  ADD PRIMARY KEY (`username`,`item_name`,`item_type`,`db_name`,`table_name`);

--
-- Chỉ mục cho bảng `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  ADD PRIMARY KEY (`page_nr`),
  ADD KEY `db_name` (`db_name`);

--
-- Chỉ mục cho bảng `pma__recent`
--
ALTER TABLE `pma__recent`
  ADD PRIMARY KEY (`username`);

--
-- Chỉ mục cho bảng `pma__relation`
--
ALTER TABLE `pma__relation`
  ADD PRIMARY KEY (`master_db`,`master_table`,`master_field`),
  ADD KEY `foreign_field` (`foreign_db`,`foreign_table`);

--
-- Chỉ mục cho bảng `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_savedsearches_username_dbname` (`username`,`db_name`,`search_name`);

--
-- Chỉ mục cho bảng `pma__table_coords`
--
ALTER TABLE `pma__table_coords`
  ADD PRIMARY KEY (`db_name`,`table_name`,`pdf_page_number`);

--
-- Chỉ mục cho bảng `pma__table_info`
--
ALTER TABLE `pma__table_info`
  ADD PRIMARY KEY (`db_name`,`table_name`);

--
-- Chỉ mục cho bảng `pma__table_uiprefs`
--
ALTER TABLE `pma__table_uiprefs`
  ADD PRIMARY KEY (`username`,`db_name`,`table_name`);

--
-- Chỉ mục cho bảng `pma__tracking`
--
ALTER TABLE `pma__tracking`
  ADD PRIMARY KEY (`db_name`,`table_name`,`version`);

--
-- Chỉ mục cho bảng `pma__userconfig`
--
ALTER TABLE `pma__userconfig`
  ADD PRIMARY KEY (`username`);

--
-- Chỉ mục cho bảng `pma__usergroups`
--
ALTER TABLE `pma__usergroups`
  ADD PRIMARY KEY (`usergroup`,`tab`,`allowed`);

--
-- Chỉ mục cho bảng `pma__users`
--
ALTER TABLE `pma__users`
  ADD PRIMARY KEY (`username`,`usergroup`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `pma__column_info`
--
ALTER TABLE `pma__column_info`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `pma__history`
--
ALTER TABLE `pma__history`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  MODIFY `page_nr` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- Cơ sở dữ liệu: `ql_banraucuqua`
--
CREATE DATABASE IF NOT EXISTS `ql_banraucuqua` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `ql_banraucuqua`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categorys`
--

CREATE TABLE `categorys` (
  `id_category` int(11) NOT NULL,
  `Name` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `categorys`
--

INSERT INTO `categorys` (`id_category`, `Name`) VALUES
(1, 'Rau củ'),
(2, 'Trái cây');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `importbilldetails`
--

CREATE TABLE `importbilldetails` (
  `id_importdetail` int(11) NOT NULL,
  `id_importbill` int(11) NOT NULL,
  `name_product` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Description` varchar(250) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `importbilldetails`
--

INSERT INTO `importbilldetails` (`id_importdetail`, `id_importbill`, `name_product`, `Description`) VALUES
(1, 5, 'k', 'q'),
(2, 6, 'ư', '2'),
(3, 7, 'e', '2'),
(4, 8, 'q', 'd');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `importbills`
--

CREATE TABLE `importbills` (
  `id_import` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `id_category` int(11) NOT NULL,
  `id_provider` int(11) NOT NULL,
  `Quatity` double NOT NULL,
  `Price` double NOT NULL,
  `Date` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `importbills`
--

INSERT INTO `importbills` (`id_import`, `id_product`, `id_category`, `id_provider`, `Quatity`, `Price`, `Date`) VALUES
(5, 30, 1, 13, 1, 2, '23-10-2022 20:22:02'),
(6, 31, 2, 15, 2, 2, '23-10-2022 23:00:18'),
(7, 32, 1, 13, 2, 2, '23-10-2022 23:00:42'),
(8, 33, 1, 13, 3, 22, '23-10-2022 23:56:15');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orderdetails`
--

CREATE TABLE `orderdetails` (
  `id_orderDetail` int(11) NOT NULL,
  `id_order` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `name_product` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Quatity` double NOT NULL,
  `Price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `orderdetails`
--

INSERT INTO `orderdetails` (`id_orderDetail`, `id_order`, `id_product`, `name_product`, `Quatity`, `Price`) VALUES
(23, 25, 16, 'ỔI PHÚC LỘC THỌ 500G', 1, 29550),
(24, 26, 17, 'VIỆT QUẤT', 1, 94900),
(25, 27, 16, 'ỔI PHÚC LỘC THỌ 500G', 1, 29550),
(26, 27, 17, 'VIỆT QUẤT', 1, 94900),
(27, 28, 22, '23', 1, 3),
(28, 29, 16, 'ỔI PHÚC LỘC THỌ 500G', 1, 29550),
(29, 30, 16, 'ỔI PHÚC LỘC THỌ 500G', 1, 29550),
(30, 31, 16, 'ỔI PHÚC LỘC THỌ 500G', 1, 29550);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
--

CREATE TABLE `orders` (
  `id_order` int(11) NOT NULL,
  `id_employee` int(11) NOT NULL,
  `id_custommer` int(11) NOT NULL,
  `Total` double NOT NULL,
  `Date` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `orders`
--

INSERT INTO `orders` (`id_order`, `id_employee`, `id_custommer`, `Total`, `Date`) VALUES
(25, 21, 1, 29550, '22-10-2022 16:44:13'),
(26, 21, 2, 94900, '22-10-2022 16:44:29'),
(27, 21, 1, 124450, '22-10-2022 16:46:09'),
(28, 21, 2, 3, '22-10-2022 23:26:23'),
(29, 29, 20, 29550, '23-10-2022 00:22:53'),
(30, 21, 1, 29550, '23-10-2022 00:26:18'),
(31, 22, 2, 29550, '23-10-2022 00:26:35');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `id_product` int(11) NOT NULL,
  `id_category` int(11) NOT NULL,
  `id_provider` int(11) NOT NULL,
  `Name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Price` double NOT NULL,
  `Quatity` double NOT NULL,
  `Description` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `img` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Date` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`id_product`, `id_category`, `id_provider`, `Name`, `Price`, `Quatity`, `Description`, `img`, `Date`) VALUES
(16, 1, 13, 'ỔI PHÚC LỘC THỌ 500G', 29550, 50, 'Ổi ròn tan', 'C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\img\\oi.jpg', '17-10-2022 22:29'),
(17, 2, 14, 'VIỆT QUẤT', 94900, 50, 'Việt quất thơm ngon', 'C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\img\\ScreenShot_20220930230417.png', '17-10-2022 22:36'),
(22, 1, 14, '23', 3, 3, 'aa', 'C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\img\\ScreenShot_20220930230845.png', '19-10-2022 00:08:20'),
(23, 1, 14, '2', 2, 2, '2', 'C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\img\\ScreenShot_20220930230511.png', '19-10-2022 00:09:45'),
(25, 2, 13, 'cá', 2, 2, 'ngon', 'C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\img\\ScreenShot_20220930230417.png', '23-10-2022 18:23:27'),
(26, 1, 13, 'mot', 3, 2, 'hay', 'C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\img\\ScreenShot_20220930230742.png', '23-10-2022 19:08:55'),
(27, 1, 13, 'mot', 3, 2, 'ngon', 'C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\img\\ScreenShot_20220930230816.png', '23-10-2022 19:55:12'),
(28, 1, 13, 'a', 3, 2, 'ngpm', 'C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\img\\ScreenShot_20220930230816.png', '23-10-2022 20:02:21'),
(29, 1, 13, '2', 2, 3, 'd', 'C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\img\\ScreenShot_20220930230722.png', '23-10-2022 20:20:28'),
(30, 1, 13, 'k', 1, 2, 'q', 'C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\img\\ScreenShot_20220930230511.png', '23-10-2022 20:22:02'),
(31, 2, 15, 'ư', 2, 2, '2', 'C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\img\\ScreenShot_20220930230531.png', '23-10-2022 23:00:18'),
(32, 1, 13, 'e', 2, 2, '2', 'C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\img\\ScreenShot_20220930230722.png', '23-10-2022 23:00:42'),
(33, 1, 13, 'q', 3, 22, 'd', 'C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\img\\ScreenShot_20220930230816.png', '23-10-2022 23:56:15');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `providers`
--

CREATE TABLE `providers` (
  `id_provider` int(11) NOT NULL,
  `nameProvider` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Phone` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Address` varchar(150) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `providers`
--

INSERT INTO `providers` (`id_provider`, `nameProvider`, `Phone`, `Address`) VALUES
(13, 'Fresh from Farm', '0982277739', '15A/53 Lê Thánh Tôn, Phường Bến Nghé, Quận 1, TP. HCM'),
(14, '5th Element', '0862983988', '1058 Đường Nguyễn Văn Linh, Phường Tân Phong, Quận 7, TP. HCM'),
(15, 'Cầu Đất Farm', '0123456987', '‎313 Nguyễn Thị Thập, Phường Tân Phú, Quận 7, TP. HCM'),
(16, 'Rau cười Việt Nhật', '0909141798', '‎117/53 Nguyễn Hữu Cảnh, Phường 22, Quận Bình Thạnh, TP. HCM'),
(17, 'VGFood', '0963556135', '‎Số 201 Nguyễn Tri Phương, Phường 9, Quận 5, TP. HCM'),
(18, 'Rau Sạch Vườn Của Mẹ', '0379466444', '‎Đường số 30, Phường Linh Đông, Thủ Đức'),
(19, 'Happy Trade', '0912057845', '‎Số 3, Đường 36C, Phường An Phú, Quận 2, TP. HCM'),
(25, 'Food', '01245689', 'an duong vuong'),
(26, 'Food 2', '01245689', 'an duong vuong'),
(30, 'khai', 'mot', 'hai'),
(31, 'khai', 'mot', 'hai'),
(32, 'khai', 'mot', 'hai'),
(33, 'khai', 'mot', 'hai'),
(35, 'khai ne', '01245689', 'hay qua'),
(36, 'hay', '01245689', 'hay qua hay'),
(37, 'qeqe', '1233211233', 'qưeqeqe'),
(38, 'hay hayádadad', '12456899', 'ádada'),
(40, 'hay ghê', '12456899', 'ádada');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `reports`
--

CREATE TABLE `reports` (
  `id_report` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `id_provider` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `Quatity` double NOT NULL,
  `Total` double NOT NULL,
  `Date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `Name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Role` int(11) NOT NULL,
  `Phone` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Address` varchar(150) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id_user`, `Name`, `Role`, `Phone`, `Address`) VALUES
(1, 'Nguyễn Hoàng Nam', 1, '0123456789', 'An Dương Vương - P.4 - Q.5 - HCM'),
(2, 'Phạm Văn Khải', 1, '0868103622', 'Đường 19/5, Tân Lân, Cần Đước, Long An, Việt Nam'),
(3, 'Hồ Hữu Cương', 1, '0123456785', 'Đ. Ao Gòn, Tân Lân, Cần Đước, Long An, Việt Nam'),
(4, 'Võ Thành Danh', 1, '0123456799', 'Tân Lân, Cần Đước, Long An, Việt Nam'),
(5, 'Huỳnh Thị  Phương Dung', 1, '0523488453', '206 Nguyễn Văn Cừ - SunHome'),
(6, 'Thạch Minh Hoàng', 1, '0856003333', '183 Chu Văn An, Đam Bri, Bảo Lộc, Lâm Đồng, Việt Nam'),
(7, 'Trần Nguyễn Khánh Hoàng', 1, '0915770055', '288 Chu Văn An, Đam Bri, Bảo Lộc, Lâm Đồng, Việt Nam'),
(11, 'Nguyễn Thị Phương Lợi', 1, '0789998181', 'HM62+PP7, Tân Sơn, Lục Ngạn, Bắc Giang, Việt Nam'),
(12, 'Bùi Ngọc Quỳnh Ngân', 1, '0792666044', 'Thôn Phạm Tân, Ngô Quyền, Thanh Miện, Hải Dương, Việt Nam'),
(13, 'Nguyễn Thị Thu Ngân', 1, '0703221177', 'R2CW+57H, Unnamed Road, Xuân Trú, Ân Thi, Hưng Yên, Việt Nam'),
(14, 'Nguyễn Huỳnh Thảo Nguyên', 1, '0764221199', 'R2F4+24J, Dân Tiến, Khoái Châu, Hưng Yên, Việt Nam'),
(15, 'Nguyễn Trọng	Nhân', 1, '0703119977', '396 Sài Thị, TT. Khoái Châu, Khoái Châu, Hưng Yên, Việt Nam'),
(16, 'Mai Đoàn Yến	Nhi', 1, '0703117744', 'Unnamed Road, Hàm Tử, Khoái Châu, Hưng Yên, Việt Nam'),
(17, 'Trần Yến	Nhi', 1, '0786668844', 'Km 17 trưng trắc, xóm Đường, Văn Lâm, Hưng Yên, Việt Nam'),
(18, 'Nguyễn Hạnh Tâm', 1, '0708335544', 'QP7P+96R, Ba Tháng Hai, TT. Ba Tơ, Ba Tơ, Quảng Ngãi, Việt Nam'),
(19, 'Nguyễn Thị Thanh Thúy', 1, '0703335500', 'tổ 2 - nước lô, Ba Giang, Ba Tơ, Quảng Ngãi, Việt Nam'),
(20, 'Nguyễn Thị Thủy Tiên', 1, '0703339900', 'RM5J+RF6, TT. Ba Tơ, Ba Tơ, Quảng Ngãi, Việt Nam'),
(21, 'Trần Thị Thu Trang', 2, '0902042007', '33 Ngô Quyền, Khóm 3, Bạc Liêu, Việt Nam'),
(22, 'Lê Ngọc Phương Trâm', 2, '0794112007', '7PHQ+4PH, Lò Rèn, Phường 5, Bạc Liêu, Việt Nam'),
(23, 'Võ Thanh Trâm', 2, '0704122007', '7PHQ+4PH, Lò Rèn, Phường 5, Bạc Liêu, Việt Nam'),
(24, 'Nguyễn Minh Trí', 2, '0904742007', '45 Lê Lợi, Phường 6, Sóc Trăng, Việt Nam'),
(27, 'Nguyễn Đức Trung', 2, '0934162007', 'JXXV+5X5, Phường 5, Sóc Trăng, Việt Nam'),
(28, 'Nguyễn Dương Nhật Trường', 2, '0587172007', '56A Phạm Ngũ Lão, Phường 1, Trà Vinh, Việt Nam'),
(29, 'Huỳnh Thị Mộng Tuyền', 2, '0589172007', 'W8RP+7CM, Phường 1, Trà Vinh, Việt Nam'),
(30, 'Ngô Thị Thúy Vy', 2, '0586172007', '405 Phạm Ngũ Lão, Khóm 4, Trà Vinh, Việt Nam'),
(31, 'Nguyễn Hoàng Hải', 1, '0123456951', 'Hồ Hoàng Kiếm - Đống Đa - Hà Nội'),
(33, 'Khai So Cute', 1, '01245689', 'an duong vuong'),
(34, 'Khai ne', 2, '01245689', 'Hoa binh'),
(35, 'long', 1, '1245689', 'an duong vuong');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `categorys`
--
ALTER TABLE `categorys`
  ADD PRIMARY KEY (`id_category`);

--
-- Chỉ mục cho bảng `importbilldetails`
--
ALTER TABLE `importbilldetails`
  ADD PRIMARY KEY (`id_importdetail`),
  ADD KEY `id_importbill` (`id_importbill`);

--
-- Chỉ mục cho bảng `importbills`
--
ALTER TABLE `importbills`
  ADD PRIMARY KEY (`id_import`),
  ADD KEY `id_product` (`id_product`),
  ADD KEY `id_category` (`id_category`,`id_provider`),
  ADD KEY `id_provider` (`id_provider`);

--
-- Chỉ mục cho bảng `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD PRIMARY KEY (`id_orderDetail`),
  ADD KEY `id_product` (`id_product`),
  ADD KEY `id_order` (`id_order`);

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id_order`),
  ADD KEY `id_user` (`id_employee`),
  ADD KEY `id_custommer` (`id_custommer`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id_product`),
  ADD KEY `id_category` (`id_category`),
  ADD KEY `id_provider` (`id_provider`);

--
-- Chỉ mục cho bảng `providers`
--
ALTER TABLE `providers`
  ADD PRIMARY KEY (`id_provider`);

--
-- Chỉ mục cho bảng `reports`
--
ALTER TABLE `reports`
  ADD PRIMARY KEY (`id_report`),
  ADD KEY `id_product` (`id_product`),
  ADD KEY `id_provider` (`id_provider`),
  ADD KEY `id_user` (`id_user`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `categorys`
--
ALTER TABLE `categorys`
  MODIFY `id_category` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `importbilldetails`
--
ALTER TABLE `importbilldetails`
  MODIFY `id_importdetail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `importbills`
--
ALTER TABLE `importbills`
  MODIFY `id_import` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `orderdetails`
--
ALTER TABLE `orderdetails`
  MODIFY `id_orderDetail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT cho bảng `orders`
--
ALTER TABLE `orders`
  MODIFY `id_order` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `id_product` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT cho bảng `providers`
--
ALTER TABLE `providers`
  MODIFY `id_provider` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `importbilldetails`
--
ALTER TABLE `importbilldetails`
  ADD CONSTRAINT `importbilldetails_ibfk_1` FOREIGN KEY (`id_importbill`) REFERENCES `importbills` (`id_import`);

--
-- Các ràng buộc cho bảng `importbills`
--
ALTER TABLE `importbills`
  ADD CONSTRAINT `importbills_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `products` (`id_product`),
  ADD CONSTRAINT `importbills_ibfk_2` FOREIGN KEY (`id_category`) REFERENCES `categorys` (`id_category`),
  ADD CONSTRAINT `importbills_ibfk_3` FOREIGN KEY (`id_provider`) REFERENCES `providers` (`id_provider`);

--
-- Các ràng buộc cho bảng `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD CONSTRAINT `orderdetails_ibfk_1` FOREIGN KEY (`id_order`) REFERENCES `orders` (`id_order`),
  ADD CONSTRAINT `orderdetails_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `products` (`id_product`);

--
-- Các ràng buộc cho bảng `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`id_employee`) REFERENCES `users` (`id_user`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`id_custommer`) REFERENCES `users` (`id_user`);

--
-- Các ràng buộc cho bảng `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`id_provider`) REFERENCES `providers` (`id_provider`),
  ADD CONSTRAINT `products_ibfk_2` FOREIGN KEY (`id_category`) REFERENCES `categorys` (`id_category`);

--
-- Các ràng buộc cho bảng `reports`
--
ALTER TABLE `reports`
  ADD CONSTRAINT `reports_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `products` (`id_product`),
  ADD CONSTRAINT `reports_ibfk_2` FOREIGN KEY (`id_provider`) REFERENCES `providers` (`id_provider`);
--
-- Cơ sở dữ liệu: `quanlybanraucuqua`
--
CREATE DATABASE IF NOT EXISTS `quanlybanraucuqua` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `quanlybanraucuqua`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `username` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`) VALUES
(1, 'phamvankhai', '123456'),
(5, 'hello1111', 'hihi'),
(6, 'hello1111', 'hihi'),
(7, 'hello1111', 'hihi');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- Cơ sở dữ liệu: `quanlycuahangdienthoai`
--
CREATE DATABASE IF NOT EXISTS `quanlycuahangdienthoai` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `quanlycuahangdienthoai`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `MaHD` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaSP` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonGia` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`MaHD`, `MaSP`, `SoLuong`, `DonGia`) VALUES
('HD2', 'SP6', 10, 20),
('HD2', 'SP1', 2, 20),
('HD1', 'SP1', 1, 20),
('HD3', 'SP4', 1, 15),
('HD3', 'SP6', 1, 20),
('HD1', 'SP2', 10, 8.2),
('HD1', 'SP3', 11, 15),
('HD4', 'SP1', 3, 20),
('HD5', 'SP23', 1, 19.9),
('HD5', 'SP4', 3, 3.9),
('HD6', 'SP4', 1, 3.9),
('HD6', 'SP3', 1, 7.9),
('HD6', 'SP8', 5, 23),
('HD6', 'SP10', 2, 23.9),
('HD7', 'SP10', 1, 23.9),
('HD7', 'SP12', 2, 7.9),
('HD7', 'SP16', 3, 11.9),
('HD7', 'SP17', 1, 5.6),
('HD8', 'SP15', 1, 5.5),
('HD8', 'SP16', 1, 11.9),
('HD9', 'SP10', 1, 23.9),
('HD9', 'SP1', 1, 20),
('HD10', 'SP13', 1, 7.9),
('HD10', 'SP5', 10, 25.7),
('HD10', 'SP6', 10, 6.5),
('HD11', 'SP1', 1, 20),
('HD11', 'SP10', 1, 23.9),
('HD11', 'SP11', 2, 15.9),
('HD12', 'SP15', 2, 5.5),
('HD12', 'SP17', 1, 5.6),
('HD12', 'SP12', 1, 7.9),
('HD12', 'SP16', 5, 11.9),
('HD13', 'SP5', 1, 25.7),
('HD13', 'SP6', 1, 6.5),
('HD13', 'SP8', 3, 23),
('HD14', 'SP23', 49, 19.9),
('HD15', 'SP10', 1, 23.9),
('HD15', 'SP1', 2, 20),
('HD15', 'SP18', 1, 24),
('HD15', 'SP19', 1, 13),
('HD16', 'SP1', 20, 20),
('HD17', 'SP1', 1, 20),
('HD18', 'SP1', 1, 20),
('HD19', 'SP1', 1, 20),
('HD20', 'SP19', 1, 13),
('HD21', 'SP1', 1, 20),
('HD22', 'SP1', 1, 20),
('HD23', 'SP1', 1, 20),
('HD24', 'SP1', 1, 20),
('HD25', 'SP23', 1, 19.9);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `MaPN` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaSP` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `SoLuong` int(10) UNSIGNED NOT NULL,
  `DonGia` float UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`MaPN`, `MaSP`, `SoLuong`, `DonGia`) VALUES
('PN2', 'SP3', 35, 7.9),
('PN3', 'SP1', 5, 20),
('PN4', 'SP14', 1, 5.5),
('PN4', 'SP12', 1, 7.9),
('PN4', 'SP1', 1, 20),
('PN4', 'SP7', 1, 15.4),
('PN6', 'SP10', 1, 23.9),
('PN6', 'SP15', 10, 5.5),
('PN6', 'SP17', 5, 5.6),
('PN7', 'SP21', 100, 8),
('PN7', 'SP22', 10, 39),
('PN8', 'SP16', 10, 11.9),
('PN9', 'SP1', 10, 20),
('PN11', 'SP9', 1, 29),
('PN12', 'SP15', 1, 5.5),
('PN13', 'SP1', 1, 20),
('PN14', 'SP1', 1, 20),
('PN15', 'SP10', 1, 23.9);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHD` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaNV` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaKH` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaKM` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `NgayLap` date NOT NULL,
  `GioLap` time NOT NULL,
  `TongTien` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`MaHD`, `MaNV`, `MaKH`, `MaKM`, `NgayLap`, `GioLap`, `TongTien`) VALUES
('HD1', 'NV3', 'KH2', 'KM2', '2019-04-18', '22:45:52', 267),
('HD10', 'NV23', 'KH16', 'KM1', '2019-04-24', '22:16:58', 329.9),
('HD11', 'NV12', 'KH22', 'KM1', '2019-04-25', '13:20:37', 75.7),
('HD12', 'NV12', 'KH19', 'KM3', '2019-04-26', '17:59:11', 84),
('HD13', 'NV12', 'KH14', 'KM1', '2019-04-26', '18:58:06', 101.2),
('HD14', 'NV12', 'KH19', 'KM3', '2019-05-01', '14:14:27', 975.1),
('HD15', 'NV12', 'KH15', 'KM5', '2019-05-05', '15:12:27', 100.9),
('HD16', 'NV12', 'KH1', 'KM4', '2019-05-10', '11:21:12', 400),
('HD17', 'NV12', 'KH20', 'KM5', '2021-11-23', '01:35:18', 20),
('HD18', 'NV12', 'KH1', 'KM5', '2021-11-26', '21:12:00', 20),
('HD19', 'NV1', 'KH18', 'KM5', '2021-11-28', '21:05:37', 20),
('HD2', 'NV1', 'KH1', 'KM1', '2019-04-18', '23:15:36', 240),
('HD20', 'NV1', 'KH18', 'KM5', '2021-12-02', '12:47:33', 13),
('HD21', 'NV1', 'KH19', 'KM5', '2021-12-02', '21:05:36', 20),
('HD22', 'NV1', 'KH1', 'KM5', '2021-12-02', '21:39:15', 20),
('HD23', 'NV1', 'KH18', 'KM5', '2021-12-02', '21:46:58', 20),
('HD24', 'NV1', 'KH18', 'KM5', '2021-12-05', '01:41:24', 20),
('HD25', 'NV1', 'KH19', 'KM5', '2021-12-08', '15:00:32', 19.9),
('HD3', 'NV1', 'KH1', 'KM1', '2019-04-19', '18:44:34', 35),
('HD4', 'NV1', 'KH1', 'KM1', '2019-04-21', '12:13:48', 60),
('HD5', 'NV15', 'KH1', 'KM1', '2019-04-24', '03:18:01', 31.6),
('HD6', 'NV15', 'KH7', 'KM1', '2019-04-24', '03:21:35', 174.6),
('HD7', 'NV15', 'KH13', 'KM1', '2019-04-24', '03:22:30', 81),
('HD8', 'NV15', 'KH3', 'KM1', '2019-04-24', '11:29:50', 17.4),
('HD9', 'NV15', 'KH12', 'KM1', '2019-04-24', '21:43:30', 43.9);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKH` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenKH` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `SDT` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `TrangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`MaKH`, `TenKH`, `DiaChi`, `SDT`, `TrangThai`) VALUES
('KH1', 'Trần Văn Hoàng', 'TP HCM', '0123456789', 0),
('KH10', 'Trần Ngọc Hải', 'Kiên Giang', '0905271941', 0),
('KH11', 'Nguyễn Xuân Diệu', 'TP HCM', '0301279552', 0),
('KH12', 'Trần Thanh Thiện', 'Hà Nội', '0123617389', 1),
('KH13', 'Huỳnh Minh Mẫn', 'An Giang', '0389230581', 0),
('KH14', 'Trần Xuân An', 'Long An', '0972136531', 0),
('KH15', 'Nguyễn Thị Xuân', 'TP HCM', '0702571936', 0),
('KH16', 'Huỳnh Anh Thư', 'Bến Tre', '0892383623', 0),
('KH17', 'Trần Thanh Nhã', 'TP HCM', '0702397442', 0),
('KH18', 'Huỳnh Nhựt Trường', 'TP HCM', '0120982736', 0),
('KH19', 'Trần Ngọc Hà', 'TP HCM', '0702843627', 1),
('KH2', 'Nguyễn Thiên Hữu', 'Huế', '0126461589', 1),
('KH20', 'Trần Thị Hoài Anh', 'TP HCM', '0126729137', 0),
('KH21', 'Nguyễn Văn Thắng', 'Kiên Giang', '0723812935', 0),
('KH22', 'Huỳnh Lê Diệu Hân', 'Hà Nội', '0306279178', 1),
('KH3', 'Phan Thanh Tùng', 'Hà Nội', '0952612771', 0),
('KH4', 'Trần Thanh Sơn', 'Hải Phòng', '0120617231', 0),
('KH5', 'Trần Thanh Thái', 'Bến Tre', '0912385524', 1),
('KH6', 'Nguyễn Hồng Nhung', 'Huế', '0967263941', 0),
('KH7', 'Từ Ngọc Cảnh', 'Sóc Trăng', '0306172915', 0),
('KH8', 'Nguyễn Thiên Phụng', 'Vũng Tàu', '0703167293', 0),
('KH9', 'Nguyễn Diệu Ái', 'TP HCM', '0805178293', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `MaKM` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenKM` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `DieuKienKM` float NOT NULL,
  `PhanTramKM` float NOT NULL,
  `NgayBD` date DEFAULT NULL,
  `NgayKT` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khuyenmai`
--

INSERT INTO `khuyenmai` (`MaKM`, `TenKM`, `DieuKienKM`, `PhanTramKM`, `NgayBD`, `NgayKT`) VALUES
('KM1', 'Không khuyến mãi', 0, 0, '2019-04-01', '2021-04-30'),
('KM2', 'Giảm giá nhân ngày 30/4', 5, 5, '2019-04-28', '2019-05-02'),
('KM3', 'Giảm giá 1/5', 20, 7.5, '2019-04-25', '2019-05-02'),
('KM4', 'Giảm giá tết', 15, 5, '2019-04-24', '2019-12-01'),
('KM5', 'Khuyến mãi xả hàng', 100, 96.69, '2021-05-05', '2022-05-06');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `MaLSP` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenLSP` varchar(70) COLLATE utf8_unicode_ci NOT NULL,
  `Mota` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `loaisanpham`
--

INSERT INTO `loaisanpham` (`MaLSP`, `TenLSP`, `Mota`) VALUES
('LSP1', 'Apple', 'Các sản phẩm của Apple'),
('LSP10', 'Nokia', 'san pham cua nokia'),
('LSP2', 'Oppo', 'Camara Selphi cuc chat tu Oppo'),
('LSP3', 'SamSung', 'Khuyen mai lon tu SamSung'),
('LSP4', 'Phillip', 'Các sản phẩm tuyệt đẹp đến từ phillip'),
('LSP5', 'Nokia', 'Các sản phẩm đến từ thương hiệu Nokia'),
('LSP6', 'Blackbery', 'BlackBery is the best'),
('LSP7', 'Huawei', 'Các sản phẩm đến từ thương hiệu Huawei'),
('LSP8', 'Vivo', 'Các sản phẩm đến từ Vivo'),
('LSP9', 'Xiaomi', 'Các sản phẩm đến từ thương hiệu Xiaomi');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNCC` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenNCC` varchar(70) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `SDT` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Fax` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNCC`, `TenNCC`, `DiaChi`, `SDT`, `Fax`) VALUES
('NCC1', 'Cty Samsung', 'TP HCM', '0123456789', '4598-8789-8789-7897'),
('NCC2', 'Cty Thương Mại Công Nghệ', 'Hà Nội', '0120728815', '3672-1782-3923-6091'),
('NCC3', 'Cty Di Động Trường Sơn', 'TP HCM', '0703192738', '2364-2974-2384-2394'),
('NCC4', 'Cty Viễn Thông Thành Đạt', 'TP HCM', '0501239237', '9823-6738-6739-6766'),
('NCC5', 'Thế Giới Công Nghệ', 'Bình Dương', '0801729329', '1830-7288-8900-7712'),
('NCC6', 'Cty TNHH Hoàng Bá', 'Long An', '0303676818', '7623-9812-3876-2834'),
('NCC7', 'Cty Di Động Thành Tiến', 'Hà Nội', '0989140736', '1873-1738-8736-4761'),
('NCC8', 'Cty Toàn Thắng', 'TP HCM', '0120628918', '8127-9382-1974-2983');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNV` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenNV` text COLLATE utf8_unicode_ci NOT NULL,
  `NgaySinh` date NOT NULL,
  `DiaChi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `SDT` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `TrangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`MaNV`, `TenNV`, `NgaySinh`, `DiaChi`, `SDT`, `TrangThai`) VALUES
('NV1', 'Phạm Văn Khải', '1978-04-05', 'Đà Nẵng', '0145647854', 0),
('NV10', 'Nguyễn Thị Hồng Hạnh', '1993-11-29', 'Bến Tre', '01262368193', 0),
('NV11', 'Phan Thị Hồng Trinh', '1993-12-11', 'Nghệ An', '0366227168', 0),
('NV12', 'Phan Văn Tài', '1989-06-15', 'Kiên Giang', '0981578293', 0),
('NV13', 'Lê Công Huynh', '1991-09-12', 'Sóc Trăng', '0977232173', 0),
('NV14', 'Lê Hồng Hoa', '1992-08-13', 'TP HCM', '0805126735', 0),
('NV15', 'Nguyễn Thị My', '1992-12-30', 'Hà Nội', '0703689147', 0),
('NV16', 'Trương Thị Hồng Huệ', '1992-11-28', 'TP HCM', '0825719263', 1),
('NV17', 'Nguyễn Thành Trung', '1992-01-16', 'Thanh Hoá', '0123691368', 0),
('NV18', 'Nguyễn Thị Cẩm Duyên', '1995-11-03', 'TP HCM', '0120984178', 0),
('NV19', 'Lê Thanh Quang', '1995-04-19', 'Huế', '0956146728', 0),
('NV2', 'Trần Văn Hi', '1999-04-05', 'TP HCM', '0123456489', 0),
('NV20', 'Nguyễn Hùng Bá', '1997-02-14', 'Hải Phòng', '0702536184', 0),
('NV21', 'Huỳnh Công Thành', '1996-11-20', 'Long An', '0709123175', 0),
('NV22', 'Huỳnh Thị Hồng Hương', '1994-11-27', 'TP HCM', '0912635198', 0),
('NV23', 'Phan Yến Hân', '1996-03-14', 'Bến Tre', '0123671823', 0),
('NV24', 'Trương Thanh Dũng', '1997-10-28', 'Đồng Tháp', '0981237651', 0),
('NV3', 'Nguyễn Bá Được', '1998-04-05', 'Hà Nội', '0128456786', 1),
('NV4', 'Trần Văn Hoàng', '1999-11-12', 'TP HCM', '01207764668', 0),
('NV5', 'Lê Thanh Tú', '1991-04-11', 'Hải Phòng', '0367756753', 1),
('NV6', 'Nguyễn Hải Âu', '1992-04-24', 'Huế', '0364198226', 0),
('NV7', 'Hoàng Thanh Hùng', '1989-11-13', 'Long An', '0276886265', 0),
('NV8', 'Trịnh Văn Công', '1990-07-16', 'Tiền Giang', '0392656931', 0),
('NV9', 'Dương Thanh Hồng', '1991-12-03', 'Vũng Tàu', '0977268398', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phanquyen`
--

CREATE TABLE `phanquyen` (
  `MaQuyen` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenQuyen` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ChiTietQuyen` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phanquyen`
--

INSERT INTO `phanquyen` (`MaQuyen`, `TenQuyen`, `ChiTietQuyen`) VALUES
('Q1', 'Quản lý', 'qlBanHang qlNhapHang qlSanPham qlLoaiSanPham qlHoaDon qlKhuyenMai qlNhanVien qlKhachHang qlPhieuNhap qlNCC qlTaiKhoan qlQuyen'),
('Q2', 'Nhân viên bán hàng', 'qlBanHang xemSanPham xemLoaiSanPham qlHoaDon xemKhuyenMai xemNhanVien qlKhachHang'),
('Q3', 'Nhân viên nhập hàng', 'qlNhapHang xemSanPham xemLoaiSanPham qlPhieuNhap xemNCC'),
('Q4', 'Phụ bán hàng', 'qlBanHang qlNhapHang xemSanPham xemLoaiSanPham xemHoaDon xemKhuyenMai xemNCC');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MaPN` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaNCC` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaNV` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `NgayNhap` date NOT NULL,
  `GioNhap` time NOT NULL,
  `TongTien` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`MaPN`, `MaNCC`, `MaNV`, `NgayNhap`, `GioNhap`, `TongTien`) VALUES
('PN11', 'NCC2', 'NV12', '2021-11-21', '15:02:23', 29),
('PN12', 'NCC1', 'NV12', '2021-11-23', '01:37:55', 5.5),
('PN13', 'NCC1', 'NV12', '2021-11-23', '13:19:56', 20),
('PN14', 'NCC1', 'NV1', '2021-11-28', '21:52:04', 20),
('PN15', 'NCC1', 'NV1', '2021-11-28', '21:56:30', 23.9),
('PN2', 'NCC3', 'NV1', '2019-04-24', '01:25:23', 276.5),
('PN3', 'NCC5', 'NV12', '2019-04-25', '17:06:52', 100),
('PN4', 'NCC4', 'NV12', '2019-04-26', '02:51:18', 48.8),
('PN6', 'NCC8', 'NV12', '2019-04-26', '17:58:26', 106.9),
('PN7', 'NCC6', 'NV12', '2019-05-01', '14:15:27', 1190),
('PN8', 'NCC1', 'NV12', '2019-05-10', '11:19:10', 119),
('PN9', 'NCC2', 'NV12', '2019-05-10', '11:19:53', 200);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `MaSP` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaLSP` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `TenSP` varchar(70) COLLATE utf8_unicode_ci NOT NULL,
  `DonGia` float NOT NULL,
  `SoLuong` int(10) UNSIGNED NOT NULL DEFAULT 1,
  `HinhAnh` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `TrangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`MaSP`, `MaLSP`, `TenSP`, `DonGia`, `SoLuong`, `HinhAnh`, `TrangThai`) VALUES
('SP1', 'LSP1', 'IPhone X', 20, 85, 'iphone-xr-128gb-red-400x400.jpg', 0),
('SP10', 'LSP1', 'iPhone Xr 256GB', 23.9, 76, 'iphone-xr-256gb-white-400x400.jpg', 0),
('SP11', 'LSP2', 'OPPO R17 Pro', 15.9, 99, 'oppo-r17-pro-2-400x460.jpg', 0),
('SP12', 'LSP8', 'Vivo V15', 7.9, 257, 'vivo-v15-quanghai-400x460.jpg', 0),
('SP13', 'LSP6', 'Blackberry Evolve', 7.9, 46, 'blackberry-evolve6xvk3-640.jpg', 0),
('SP14', 'LSP7', 'Huawei Y9 (2019)', 5.5, 37, 'huawei-y9-2019-blue-400x460.jpg', 0),
('SP15', 'LSP2', 'OPPO F7', 5.5, 362, 'oppo-f7-red-mtp-400x460.jpg', 0),
('SP16', 'LSP9', 'Xiaomi Mi 8', 11.9, 51, 'xiaomi-mi-8-1-400x460-400x460.jpg', 0),
('SP17', 'LSP9', 'Xiaomi Redmi Note 6 Pro 64GB', 5.6, 68, 'xiaomi-redmi-note-6-pro-black-1-400x460.jpg', 0),
('SP18', 'LSP3', 'Samsung Galaxy Note 9 512GB', 24, 59, 'samsung-galaxy-note-9-512gb-blue-400x460.jpg', 1),
('SP19', 'LSP7', 'Huawei Mate 20', 13, 43, 'huawei-mate-20-black-400x460.jpg', 0),
('SP2', 'LSP2', 'Oppo A7', 8.2, 70, 'oppo-a7-400x460.jpg', 0),
('SP20', 'LSP8', 'Vivo Y85', 5, 36, 'vivo-y85-red-docquyen-400x460.jpg', 0),
('SP21', 'LSP8', 'Vivo V11', 8, 130, 'vivo-v11-400x460.jpg', 0),
('SP22', 'LSP1', 'iPhone Xs Max 512GB', 39, 55, 'iphone-xs-max-512gb-gold-400x460.jpg', 0),
('SP23', 'LSP2', 'OPPO Fid X', 19.9, 0, 'oppo-find-x-1-400x460-400x460.jpg', 0),
('SP24', 'LSP1', 'Iphone abc', 25, 20, 'iphone-xr-256gb-white-400x400.jpg', 0),
('SP3', 'LSP5', 'Nokia 8.1', 7.9, 69, 'nokia-81-silver-400x460.jpg', 0),
('SP4', 'LSP4', 'Philips S327', 2, 56, 'philips-s327-400-400x460.jpg', 0),
('SP5', 'LSP1', 'iPhone 8 Plus 256GB', 25.7, 167, 'iphone-8-plus-256gb-gold-400x460.jpg', 0),
('SP6', 'LSP5', 'Nokia 6.1 Plus', 6.5, 44, 'nokia-61-plus-3-400x460.jpg', 1),
('SP7', 'LSP2', 'Oppo NEO 3', 15.4, 101, 'oppo-a7-32gb-gold-400x400.jpg', 1),
('SP8', 'LSP7', 'Huawei P30 Pro', 23, 69, 'huawei-p30-pro-1-400x460.jpg', 1),
('SP9', 'LSP3', 'Samsung Galaxy S10+ (512GB)', 29, 58, 'samsung-galaxy-s10-plus-512gb-ceramic-black-400x460.jpg', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `TenTaiKhoan` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `MatKhau` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `MaNV` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaQuyen` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`TenTaiKhoan`, `MatKhau`, `MaNV`, `MaQuyen`) VALUES
('nhanvien1', '123', 'NV18', 'Q2'),
('nhanvien2', '123', 'NV22', 'Q3'),
('nhanvien3', '123', 'NV2', 'Q4'),
('quanly1', '123', 'NV1', 'Q1');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD KEY `MaSP` (`MaSP`),
  ADD KEY `MaHD` (`MaHD`);

--
-- Chỉ mục cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD KEY `MaSP` (`MaSP`),
  ADD KEY `MaPN` (`MaPN`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHD`),
  ADD KEY `MaNV` (`MaNV`),
  ADD KEY `MaKH` (`MaKH`),
  ADD KEY `MaKM` (`MaKM`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MaKH`);

--
-- Chỉ mục cho bảng `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`MaKM`);

--
-- Chỉ mục cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`MaLSP`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNV`);

--
-- Chỉ mục cho bảng `phanquyen`
--
ALTER TABLE `phanquyen`
  ADD PRIMARY KEY (`MaQuyen`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MaPN`),
  ADD KEY `MaNCC` (`MaNCC`),
  ADD KEY `MaNV` (`MaNV`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaSP`),
  ADD KEY `LoaiSP` (`MaLSP`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`TenTaiKhoan`),
  ADD KEY `MaQuyen` (`MaQuyen`),
  ADD KEY `MaNV` (`MaNV`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `chitiethoadon_ibfk_1` FOREIGN KEY (`MaHD`) REFERENCES `hoadon` (`MaHD`) ON UPDATE CASCADE,
  ADD CONSTRAINT `chitiethoadon_ibfk_2` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `chitietphieunhap_ibfk_2` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`) ON UPDATE CASCADE,
  ADD CONSTRAINT `chitietphieunhap_ibfk_3` FOREIGN KEY (`MaPN`) REFERENCES `phieunhap` (`MaPN`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`) ON UPDATE CASCADE,
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON UPDATE CASCADE,
  ADD CONSTRAINT `khuyenmai_ibfk_3` FOREIGN KEY (`MaKM`) REFERENCES `khuyenmai` (`MaKM`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`MaNCC`) REFERENCES `nhacungcap` (`MaNCC`) ON UPDATE CASCADE,
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`MaLSP`) REFERENCES `loaisanpham` (`MaLSP`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON UPDATE CASCADE,
  ADD CONSTRAINT `taikhoan_ibfk_3` FOREIGN KEY (`MaQuyen`) REFERENCES `phanquyen` (`MaQuyen`) ON UPDATE CASCADE;
--
-- Cơ sở dữ liệu: `test`
--
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test`;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
