-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 10, 2022 lúc 09:55 AM
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
(6, 10, 'ỔI PHÚC LỘC THỌ 500G', 'Giòn ngọt'),
(7, 11, 'CHUỐI FOHLA 1KG', 'Chuối Fohla giống chuối Nam Mỹ được trồng ở Đức Huệ - Long An'),
(8, 12, 'CẢI THÌA RAU CƯỜI VIỆT NHẬT 250G', '  MÔ TẢ CHUNG: CẢI THÌA RAU CƯỜI VIỆT NHẬT'),
(9, 13, 'CỦ DỀN HỮU CƠ 500G', ''),
(10, 14, 'LỰU ISRAEL 500G', 'LỰU ISRAEL nhập khẩu 100%'),
(11, 15, 'LÁ HƯƠNG THẢO', ''),
(12, 16, 'NHO XANH KHÔNG HẠT', 'Nho xanh không hạt  được trồng tại nơi có khí hậu ôn đới nơi không khí khô và nhiều nắng. Bởi như thế mới không bị sâu bệnh tấn công và tạo điều kiện phát triển ra quả nho ngon nhất.'),
(13, 17, 'NHO ĐEN KHÔ DAN D PARK', 'Các loại nho khô vàng, xanh hay đen đều được mọi người yêu thích, đặc biệt là trẻ nhỏ. Nho khô được sử dụng rộng rãi trên toàn thế giới  Thực tế, lợi ích cho sức khỏe và giá trị dinh dưỡng của nho khô đen có thể được gọi là “viên ngọc quý”.'),
(14, 18, 'KHÓM WESTFOODS', 'Vị chua thanh thanh'),
(15, 19, 'THANH LONG RUỘT ĐỎ 500G', 'Thanh long ruột đỏ là một trong những loại trái cây tươi có thành phần dinh dưỡng phù hợp nhất cho việc giữ gìn dáng vóc và sắc đẹp, đặc biệt là với phụ nữ.');

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
(10, 35, 1, 13, 50, 1497500, '27-10-2022 00:50:52'),
(11, 36, 2, 14, 15, 772500, '27-10-2022 00:52:37'),
(12, 37, 1, 13, 25, 997500, '27-10-2022 00:57:34'),
(13, 38, 1, 13, 64, 4156800, '27-10-2022 01:00:48'),
(14, 39, 2, 19, 101, 1509950, '27-10-2022 01:02:50'),
(15, 40, 1, 50, 25, 173975, '27-10-2022 01:04:23'),
(16, 41, 2, 47, 77, 13471.15, '27-10-2022 01:07:34'),
(17, 42, 2, 47, 33, 4333989, '27-10-2022 01:23:58'),
(18, 43, 2, 17, 44, 542212, '27-10-2022 01:25:39'),
(19, 44, 2, 19, 44, 537812, '27-10-2022 01:26:51');

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
(35, 35, 35, 'ỔI PHÚC LỘC THỌ 500G', 2, 59900),
(36, 35, 36, 'CHUỐI FOHLA 1KG', 1, 51500),
(37, 35, 37, 'CẢI THÌA RAU CƯỜI VIỆT NHẬT 250G', 1, 39900),
(38, 35, 38, 'CỦ DỀN HỮU CƠ 500G', 2, 129900),
(39, 35, 39, 'LỰU ISRAEL 500G', 1, 14950),
(40, 36, 38, 'CỦ DỀN HỮU CƠ 500G', 1, 64950),
(41, 36, 36, 'CHUỐI FOHLA 1KG', 1, 51500),
(42, 36, 39, 'LỰU ISRAEL 500G', 3, 44850),
(43, 37, 36, 'CHUỐI FOHLA 1KG', 2.5, 128750),
(44, 37, 35, 'ỔI PHÚC LỘC THỌ 500G', 3.75, 112312),
(45, 37, 40, 'LÁ HƯƠNG THẢO', 1, 6959),
(46, 38, 40, 'LÁ HƯƠNG THẢO', 0.2, 1392),
(47, 38, 39, 'LỰU ISRAEL 500G', 1, 14950),
(48, 38, 38, 'CỦ DỀN HỮU CƠ 500G', 1, 64950),
(49, 39, 35, 'ỔI PHÚC LỘC THỌ 500G', 1, 29950),
(50, 39, 38, 'CỦ DỀN HỮU CƠ 500G', 1, 64950),
(51, 39, 44, 'THANH LONG RUỘT ĐỎ 500G', 4.4, 53781),
(52, 39, 40, 'LÁ HƯƠNG THẢO', 1, 6959),
(53, 40, 37, 'CẢI THÌA RAU CƯỜI VIỆT NHẬT 250G', 2, 79800),
(54, 40, 39, 'LỰU ISRAEL 500G', 1, 14950),
(55, 41, 38, 'CỦ DỀN HỮU CƠ 500G', 1, 64950),
(56, 41, 36, 'CHUỐI FOHLA 1KG', 1, 51500),
(57, 41, 40, 'LÁ HƯƠNG THẢO', 1, 6959),
(58, 41, 37, 'CẢI THÌA RAU CƯỜI VIỆT NHẬT 250G', 1, 39900),
(59, 42, 39, 'LỰU ISRAEL 500G', 1, 14950),
(60, 42, 38, 'CỦ DỀN HỮU CƠ 500G', 1, 64950),
(61, 42, 35, 'ỔI PHÚC LỘC THỌ 500G', 1, 29950),
(62, 42, 43, 'KHÓM WESTFOODS', 1, 12323),
(63, 43, 43, 'KHÓM WESTFOODS', 1, 12323),
(64, 44, 44, 'THANH LONG RUỘT ĐỎ 500G', 1, 12223),
(65, 45, 42, 'NHO ĐEN KHÔ DAN D PARK', 1, 131333),
(66, 45, 39, 'LỰU ISRAEL 500G', 1, 14950),
(67, 46, 41, 'NHO XANH KHÔNG HẠT', 1, 175),
(68, 47, 41, 'NHO XANH KHÔNG HẠT', 1, 175);

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
(35, 21, 1, 296150, '27-10-2022 01:29:04'),
(36, 41, 31, 161300, '27-10-2022 01:29:23'),
(37, 24, 4, 248021, '27-10-2022 01:30:58'),
(38, 24, 19, 81292, '27-10-2022 01:31:33'),
(39, 27, 3, 155640, '27-10-2022 01:37:11'),
(40, 24, 2, 94750, '27-10-2022 01:37:46'),
(41, 27, 3, 163309, '27-10-2022 01:38:17'),
(42, 23, 4, 122173, '27-10-2022 01:38:31'),
(43, 23, 4, 12323, '27-10-2022 01:38:40'),
(44, 27, 3, 12223, '27-10-2022 01:38:47'),
(45, 30, 12, 146283, '27-10-2022 01:39:02'),
(46, 40, 15, 175, '27-10-2022 01:39:13'),
(47, 28, 3, 175, '27-10-2022 01:39:27');

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
  `img` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `Date` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`id_product`, `id_category`, `id_provider`, `Name`, `Price`, `Quatity`, `Description`, `img`, `Date`) VALUES
(35, 1, 13, 'ỔI PHÚC LỘC THỌ 500G', 29950, 42.25, 'Giòn ngọt', 'C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\img\\oi.jpg', '27-10-2022 00:50:52'),
(36, 2, 14, 'CHUỐI FOHLA 1KG', 51500, 9.5, 'Chuối Fohla giống chuối Nam Mỹ được trồng ở Đức Huệ - Long An', 'C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\img\\ScreenShot_20220930230449.png', '27-10-2022 00:52:37'),
(37, 1, 13, 'CẢI THÌA RAU CƯỜI VIỆT NHẬT 250G', 39900, 22, '  MÔ TẢ CHUNG: CẢI THÌA RAU CƯỜI VIỆT NHẬT', 'C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\img\\ScreenShot_20221027005545.png', '27-10-2022 00:57:34'),
(38, 1, 13, 'CỦ DỀN HỮU CƠ 500G', 64950, 56, 'Tím mộng mơ', 'C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\img\\ScreenShot_20220930231935.png', '27-10-2022 01:20:57'),
(39, 2, 19, 'LỰU ISRAEL 500G', 14950, 93, 'LỰU ISRAEL nhập khẩu 100%', 'C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\img\\ScreenShot_20220930231256.png', '27-10-2022 01:02:50'),
(40, 1, 50, 'LÁ HƯƠNG THẢO', 6959, 21.8, 'Hương thơm ngào ngạt', 'C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\img\\ScreenShot_20220930232057.png', '27-10-2022 01:18:19'),
(41, 2, 47, 'NHO XANH KHÔNG HẠT', 178322, 75, 'Nho xanh không hạt  được trồng tại nơi có khí hậu ôn đới nơi không khí khô và nhiều nắng. Bởi như thế mới không bị sâu bệnh tấn công và tạo điều kiện phát triển ra quả nho ngon nhất.', 'C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\img\\ScreenShot_20220930230630.png', '27-10-2022 01:40:01'),
(42, 2, 47, 'NHO ĐEN KHÔ DAN D PARK', 131333, 32, 'Các loại nho khô vàng, xanh hay đen đều được mọi người yêu thích, đặc biệt là trẻ nhỏ. Nho khô được sử dụng rộng rãi trên toàn thế giới  Thực tế, lợi ích cho sức khỏe và giá trị dinh dưỡng của nho khô đen có thể được gọi là “viên ngọc quý”.', 'C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\img\\ScreenShot_20220930231021.png', '27-10-2022 01:23:58'),
(43, 2, 17, 'KHÓM WESTFOODS', 12323, 42, 'Vị chua thanh thanh', 'C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\img\\ScreenShot_20220930231203.png', '27-10-2022 01:25:39'),
(44, 2, 19, 'THANH LONG RUỘT ĐỎ 500G', 12223, 40.3, 'Thanh long ruột đỏ là một trong những loại trái cây tươi có thành phần dinh dưỡng phù hợp nhất cho việc giữ gìn dáng vóc và sắc đẹp, đặc biệt là với phụ nữ.', 'C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\img\\ScreenShot_20220930231100.png', '27-10-2022 01:26:51');

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
(41, 'Thực phẩm chi nông', '0911008006', 'Số 60 ngõ 28 Xuân La, Tây Hồ, Hà Nội'),
(43, 'Thực phẩm sạch chất Việt', '0902175718', 'Số 4 Cao Đạt, Hai Bà Trưng, Hà Nội'),
(44, 'Thực phẩm an toàn Ecofoods', '0936099655', 'Số 30 Ngụy Như Kon Tum, Thanh Xuân, Hà Nội'),
(45, 'Cửa hàng Homefood', '0937960088', 'Số 19 Trúc Khê, Đống Đa, Hà Nội'),
(46, 'Nông sản ngon', '0243856888', '224 Hoàng Ngân, Trung Hoà, Cầu Giấy, Hà Nội'),
(47, 'Rau sạch CleverFood', '0968589886', 'LỮ ĐOÀN Cầu Giấy: 10/106 Hoàng Quốc Việt'),
(48, 'Rau an toàn xã Vân Nội', '0962243863', ' Xóm Ðầm, Vân Nội, Ðông Anh, Hà Nội'),
(49, 'Biggreen Việt Nam', '0129629599', 'Số 115 Hoàng Văn Thái, quận Thanh Xuân, Hà Nội'),
(50, 'Hệ thống siêu thị Orfarm', '0918836911', 'Tầng 1, TTTM Syrena Tower, 51 Xuân Diệu, Quận Tây Hồ, TP Hà Nội');

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
(39, 'Nguyễn Thị Kim	 Anh ', 2, '0924608193', 'Thanh Xuân, Hà Nội '),
(40, 'Phạm Hồng Anh ', 2, '0924655434', 'Thanh Xuân, Hà Nội '),
(41, 'Vũ Việt Bách', 2, '0353010014', 'Hoàn Kiếm, Hà Nội');

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
  MODIFY `id_category` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `importbilldetails`
--
ALTER TABLE `importbilldetails`
  MODIFY `id_importdetail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `importbills`
--
ALTER TABLE `importbills`
  MODIFY `id_import` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT cho bảng `orderdetails`
--
ALTER TABLE `orderdetails`
  MODIFY `id_orderDetail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;

--
-- AUTO_INCREMENT cho bảng `orders`
--
ALTER TABLE `orders`
  MODIFY `id_order` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `id_product` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT cho bảng `providers`
--
ALTER TABLE `providers`
  MODIFY `id_provider` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
