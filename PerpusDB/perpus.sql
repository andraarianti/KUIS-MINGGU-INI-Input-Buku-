-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 14 Apr 2020 pada 22.29
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpus`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `anggota`
--

CREATE TABLE `anggota` (
  `nis` int(11) NOT NULL,
  `namaA` varchar(50) NOT NULL,
  `ttl` varchar(15) NOT NULL,
  `jk` varchar(15) NOT NULL,
  `agama` varchar(15) NOT NULL,
  `kelas` varchar(15) NOT NULL,
  `daftar` varchar(15) NOT NULL,
  `exp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `anggota`
--

INSERT INTO `anggota` (`nis`, `namaA`, `ttl`, `jk`, `agama`, `kelas`, `daftar`, `exp`) VALUES
(123, 'andra', '07-05-20', ' Laki-Laki ', 'Islam', 'B', '15-04-20', '15-04-22');

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku`
--

CREATE TABLE `buku` (
  `kode` int(11) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `pengarang` varchar(50) NOT NULL,
  `penerbit` varchar(50) NOT NULL,
  `terbit` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `karyawan`
--

CREATE TABLE `karyawan` (
  `nik` int(9) NOT NULL,
  `namaK` varchar(50) NOT NULL,
  `jk` varchar(50) NOT NULL,
  `golongan` varchar(30) NOT NULL,
  `jabatan` varchar(30) NOT NULL,
  `tunjangan` varchar(30) NOT NULL,
  `gaji` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `karyawan`
--

INSERT INTO `karyawan` (`nik`, `namaK`, `jk`, `golongan`, `jabatan`, `tunjangan`, `gaji`) VALUES
(123, 'a', ' Laki-Laki ', '1', 'Ketua', '500.000', '1.000.000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengembalian`
--

CREATE TABLE `pengembalian` (
  `np` int(11) NOT NULL,
  `nis` int(11) DEFAULT NULL,
  `kode` int(11) DEFAULT NULL,
  `namaK` varchar(50) DEFAULT NULL,
  `pinjam` date DEFAULT NULL,
  `kembali` date DEFAULT NULL,
  `nik` int(11) DEFAULT NULL,
  `namaP` varchar(111) DEFAULT NULL,
  `kelas` varchar(111) DEFAULT NULL,
  `judul` varchar(111) DEFAULT NULL,
  `penerbit` varchar(111) DEFAULT NULL,
  `lama` varchar(111) DEFAULT NULL,
  `denda` varchar(111) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pengembalian`
--

INSERT INTO `pengembalian` (`np`, `nis`, `kode`, `namaK`, `pinjam`, `kembali`, `nik`, `namaP`, `kelas`, `judul`, `penerbit`, `lama`, `denda`) VALUES
(1, 123, NULL, 'fhg', '2020-04-15', '2020-04-22', 123, 'xcv', NULL, NULL, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`nis`);

--
-- Indeks untuk tabel `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`kode`);

--
-- Indeks untuk tabel `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`nik`);

--
-- Indeks untuk tabel `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD PRIMARY KEY (`np`),
  ADD KEY `nis` (`nis`),
  ADD KEY `nik` (`nik`),
  ADD KEY `kode` (`kode`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD CONSTRAINT `pengembalian_ibfk_1` FOREIGN KEY (`nis`) REFERENCES `anggota` (`nis`),
  ADD CONSTRAINT `pengembalian_ibfk_2` FOREIGN KEY (`nik`) REFERENCES `karyawan` (`nik`),
  ADD CONSTRAINT `pengembalian_ibfk_3` FOREIGN KEY (`kode`) REFERENCES `buku` (`kode`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
