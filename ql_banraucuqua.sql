-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 01, 2022 lúc 08:17 AM
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
-- Cơ sở dữ liệu: `ql_banraucuqua`
--

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
-- Cấu trúc bảng cho bảng `orderdetails`
--

CREATE TABLE `orderdetails` (
  `id_orderDetail` int(11) NOT NULL,
  `id_order` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `Quatity` int(11) NOT NULL,
  `Price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
--

CREATE TABLE `orders` (
  `id_order` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_custommer` int(11) NOT NULL,
  `Total` double NOT NULL,
  `Date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `id_product` int(11) NOT NULL,
  `id_category` int(11) NOT NULL,
  `id_provider` int(11) NOT NULL,
  `Name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Price` int(11) NOT NULL,
  `Quatity` int(11) NOT NULL,
  `Description` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `img` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`id_product`, `id_category`, `id_provider`, `Name`, `Price`, `Quatity`, `Description`, `img`) VALUES
(3, 1, 1, 'LÁ HƯƠNG THẢO', 16995, 1, 'Lá cây hương thảo có mùi thơm nhẹ, không chỉ có tác dụng làm gia vị, cây còn có nhiều tác dụng trong hỗ trợ và điều trị bệnh lý.', NULL);

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
(1, 'CÔNG TY TNHH TM NÔNG SẢN THỰC PHẨM ĐỒNG XANH', '0936685268', '34/23 Hoàng Ngọc Phách P. Phú Thọ Hòa Quận Tân Phú'),
(12, 'Organic Food', '0931771088', '‎Số 93 Trần Não, Phường Bình An, Quận 2, TP. HCM'),
(13, 'Fresh from Farm', '0982277739', '15A/53 Lê Thánh Tôn, Phường Bến Nghé, Quận 1, TP. HCM'),
(14, '5th Element', '0862983988', '1058 Đường Nguyễn Văn Linh, Phường Tân Phong, Quận 7, TP. HCM'),
(15, 'Cầu Đất Farm', '0123456987', '‎313 Nguyễn Thị Thập, Phường Tân Phú, Quận 7, TP. HCM'),
(16, 'Rau cười Việt Nhật', '0909141798', '‎117/53 Nguyễn Hữu Cảnh, Phường 22, Quận Bình Thạnh, TP. HCM'),
(17, 'VGFood', '0963556135', '‎Số 201 Nguyễn Tri Phương, Phường 9, Quận 5, TP. HCM'),
(18, 'Rau Sạch Vườn Của Mẹ', '0379466444', '‎Đường số 30, Phường Linh Đông, Thủ Đức'),
(19, 'Happy Trade', '0912057845', '‎Số 3, Đường 36C, Phường An Phú, Quận 2, TP. HCM'),
(20, 'Thực phẩm Tấn Tài', '0706675696', '‎165 Nguyễn Thái Bình, Quận 1, TP. HCM');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `reports`
--

CREATE TABLE `reports` (
  `id_report` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `id_provider` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
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
(30, 'Ngô Thị Thúy Vy', 2, '0586172007', '405 Phạm Ngũ Lão, Khóm 4, Trà Vinh, Việt Nam');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `categorys`
--
ALTER TABLE `categorys`
  ADD PRIMARY KEY (`id_category`);

--
-- Chỉ mục cho bảng `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD PRIMARY KEY (`id_orderDetail`),
  ADD KEY `id_order` (`id_order`),
  ADD KEY `id_product` (`id_product`);

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id_order`),
  ADD KEY `id_user` (`id_user`),
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
  MODIFY `id_category` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `id_product` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `providers`
--
ALTER TABLE `providers`
  MODIFY `id_provider` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- Các ràng buộc cho các bảng đã đổ
--

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
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`id_custommer`) REFERENCES `users` (`id_user`);

--
-- Các ràng buộc cho bảng `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`id_category`) REFERENCES `categorys` (`id_category`),
  ADD CONSTRAINT `products_ibfk_2` FOREIGN KEY (`id_provider`) REFERENCES `providers` (`id_provider`);

--
-- Các ràng buộc cho bảng `reports`
--
ALTER TABLE `reports`
  ADD CONSTRAINT `reports_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `products` (`id_product`),
  ADD CONSTRAINT `reports_ibfk_3` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`),
  ADD CONSTRAINT `reports_ibfk_4` FOREIGN KEY (`id_provider`) REFERENCES `providers` (`id_provider`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
