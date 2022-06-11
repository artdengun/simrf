-- INSERT DATA MEMBER USER 5 ORANG 2 MANAJER, 2 LEADER, 2 CREW
-- MANAGER
INSERT INTO users (nama, alamat, jenis_kelamin, pendidikan, telephone, status_perkawinan, tanggal_join, email, username, "password", enabled)
VALUES('Toyib', 'Kp. Cipinang Raya', 'LAKI_LAKI', 'SMK', '085624218852', 'MENIKAH', '20-04-2017', 'toyibun242@gmail.com', 'toyib', '$2a$12$w/Z0DUfp66qSvXl5OP37VO1rFKJEw3iKnvh.DDlVx4W6SiFbwCSpO',true);
-- MANAGER
INSERT INTO users (nama, alamat, jenis_kelamin, pendidikan, telephone, status_perkawinan, tanggal_join, email, username, "password", enabled)
VALUES('septian', 'Kp. Depok Raya', 'LAKI_LAKI', 'SMK', '08185226644', 'BELUM_MENIKAH', '15-04-2015', 'septian521@gmail.com', 'septian', '$2a$12$Zdtg0ZWSck4tbECc9MPJQO5DktkJgV78dtntN3js/rJClLkwcg.X6',true);
---- LEADER
INSERT INTO users (nama, alamat, jenis_kelamin, pendidikan, telephone, status_perkawinan, tanggal_join, email, username, "password", enabled)
VALUES('Deni Gunawan', 'Kp.Rawa Gede', 'LAKI_LAKI', 'SARJANA', '085695836255', 'BELUM_MENIKAH', '20-11-2016', 'denigunawan@gmail.com', 'deni', '$2a$12$dZmVSmY72T7ygVldkZlU0uhGmqcgUcb8G6vJWTJBu8GLiRjduZ/ra',true);
---- LEADER
INSERT INTO users (nama, alamat, jenis_kelamin, pendidikan, telephone, status_perkawinan, tanggal_join, email, username, "password", enabled)
VALUES('Tito', 'Jln. Kramat Jati', 'LAKI_LAKI', 'SMK', '0878624212251', 'MENIKAH', '20-11-2016', 'tito@gmail.com', 'tito', '$2a$12$c2JSWZlxdHUWgb7pk/V2dOUgWG1MUUQLrq/IlGfmZLS5yQatAwQhW',true);
---- CREW
INSERT INTO users (nama, alamat, jenis_kelamin, pendidikan, telephone, status_perkawinan, tanggal_join, email, username, "password", enabled)
VALUES('Muji', 'Jln. Jatinegara ', 'LAKI_LAKI', 'SMK', '0856142451266', 'MENIKAH', '11-11-2016', 'muji@gmail.com', 'muji', '$2a$12$cvYsu6A.AZuEVDiiL/wpMOYtELJcKNzEUTTIZWFUHgjA74ot6.3xe',true);
---- CREW
INSERT INTO users (nama, alamat, jenis_kelamin, pendidikan, telephone, status_perkawinan, tanggal_join, email, username, "password", enabled)
VALUES('Satriawan', 'Jln. Matraman Raya', 'LAKI_LAKI', 'SMK', '085624218852', 'BELUM_MENIKAH', '20-05-2016', 'satriawan@gmail.com', 'satriawan', '$2a$12$ToWKgZLS1eWo41U5ZUUBweWepPgtMaHvmLJ1JTNu5hftLOZoLsqy6',true);

-- superadmin
INSERT INTO users (nama, alamat, jenis_kelamin, pendidikan, telephone, status_perkawinan, tanggal_join, email, username, "password", enabled)
VALUES('Asmita Sari', 'Kp. Payangan ', 'PEREMPUAN', 'SARJANA', '087852415252', 'BELUM_MENIKAH', '20-04-2022', 'asmitasari@gmail.com', 'asmitasari', '$2a$12$KGnQN7M/NY4gGOmFYqDwlu9y6jk0LcN1w.U/wgir63uXdkjk0D7OS',true);

INSERT INTO roles ("name") VALUES('MANAJER');
INSERT INTO roles ("name") VALUES('LEADER');
INSERT INTO roles ("name") VALUES('CREW');
INSERT INTO roles ("name") VALUES('SUPERUSER');

INSERT INTO users_roles (user_id, role_id) VALUES(1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES(2, 1);
INSERT INTO users_roles (user_id, role_id) VALUES(3, 2);
INSERT INTO users_roles (user_id, role_id) VALUES(4, 2);
INSERT INTO users_roles (user_id, role_id) VALUES(5, 3);
INSERT INTO users_roles (user_id, role_id) VALUES(6, 3);
INSERT INTO users_roles (user_id, role_id) VALUES(7, 4);

---- DATA ASSET
INSERT INTO asset
( no_assets, tanggal_diterima, nama, quantity, harga_assets, tanggal_input, vendor, jenis, user_id)
VALUES('RKI0000000123', '11-02-2018', 'C0hiller', '2', 85000000, '05-06-2022', 'PT_RICHEESE', 'EQUIPMENT', 1);
INSERT INTO asset
( no_assets, tanggal_diterima, nama, quantity, harga_assets, tanggal_input, vendor, jenis, user_id)
VALUES('RKI0000000101', '09-09-2018',  'TV Panasonic', '6', 10000000, '05-06-2022', 'PT_RICHEESE', 'EQUIPMENT', 1);
INSERT INTO asset
(no_assets, tanggal_diterima, nama, quantity, harga_assets, tanggal_input, vendor, jenis, user_id)
VALUES('RKI0000000111', '05-06-2018',  'Cheese Freezer', '2', 45000000, '05-06-2022', 'PT_RICHEESE', 'EQUIPMENT', 2);
INSERT INTO asset
(no_assets, tanggal_diterima, nama, quantity, harga_assets, tanggal_input, vendor, jenis, user_id)
VALUES('RKI0000000150', '13-11-2018',  'CCTV', '4', 8000000, '05-06-2022', 'PT_RICHEESE', 'EQUIPMENT', 2);

-- DATA FROZEN
INSERT INTO frozen
(nama_product, suhu_product, production_date, exp_date, quantity, code_barang, tanggal_penerimaan, deskripsi, vendor, negara, uom, user_id)
VALUES('cut 20', '2.4', '05-06-2022', '05-12-2022', '24', 'p', '05-06-2022', 'ok', 'PT_CIOMAS', 'INA', 'PAC', 5);
INSERT INTO frozen
(nama_product, suhu_product, production_date, exp_date, quantity, code_barang, tanggal_penerimaan, deskripsi, vendor, negara, uom, user_id)
VALUES( 'ori', '2.6', '05-06-2022', '05-12-2022', '24', 'p', '05-06-2022', 'ok', 'PT_CIOMAS', 'INA', 'PAC', 5);
INSERT INTO frozen
(nama_product, suhu_product, production_date, exp_date, quantity, code_barang, tanggal_penerimaan, deskripsi, vendor, negara, uom, user_id)
VALUES('french fries', '0.7', '05-06-2022', '05-06-2023', '1', 'p', '05-06-2022', 'ok', 'PT_DELISARI', 'INA', 'PAC', 6);
---- DATA RAW
INSERT INTO raw (nama_product, production_date, exp_date, quantity, code_barang, tanggal_penerimaan, deskripsi, vendor, negara, uom, user_id)
VALUES('Reguler Breader', '11-04-2022', '11-04-2023', '18', 'ckr1002', '20-07-2022', 'ok', 'PT_KERRY', 'INA', 'KG', 5);
INSERT INTO raw (nama_product, production_date, exp_date, quantity, code_barang, tanggal_penerimaan, deskripsi, vendor, negara, uom, user_id)
VALUES('Cheese DIP 2', '03-03-2022', '03-03-2023', '20', 'p', '20-07-2022', 'ok', 'PT_KERRY', 'INA', 'PAC', 6);
INSERT INTO raw (nama_product, production_date, exp_date, quantity, code_barang, tanggal_penerimaan, deskripsi, vendor, negara, uom, user_id)
VALUES('Fry Oil', '01-02-2022', '01-02-2023', '18', 'ckr10521', '20-07-2022', 'ok', 'PT_SINARMAS', 'INA', 'KG', 6);

---- DATA RETUR
INSERT INTO retur (nama_barang, production_date, exp_date, jumlah_retur, code_barang, tanggal_retur, deskripsi, vendor, negara, uom, user_id)
VALUES('cut 20 ', '05-06-2022', '05-12-2022', '12', 'p', '10-07-2022', 'Retur Potongan Kecil', 'PT_CIOMAS', 'INA', 'PAC', 4);
INSERT INTO retur (nama_barang, production_date, exp_date, jumlah_retur, code_barang, tanggal_retur, deskripsi, vendor, negara, uom, user_id)
VALUES('ori', '05-06-2022', '05-12-2022', '12', 'p', '10-07-2022', 'Retur Potongan Kecil','PT_CIOMAS', 'INA', 'PAC', 3);
INSERT INTO retur (nama_barang, production_date, exp_date, jumlah_retur, code_barang, tanggal_retur, deskripsi, vendor, negara, uom, user_id)
VALUES('wings', '05-06-2022', '05-12-2022', '12', 'p', '10-07-2022', 'Retur Potongan Kecil', 'PT_CIOMAS', 'INA', 'PAC', 3);

---- DATA TRANSFERPLANT
INSERT INTO transfer_plant (tanggal_dikirim, no_dokumen, nama_barang, quantity_barang, outlet_penerima, outlet_pengirim, mod_incharge, uom, user_id)
VALUES( '10-07-2022', 'TRF10001','ORI', '12', 'Richeese Factory Jatiwaringin', 'Richeese Factory Hankam', 'ade', 'PAC', 4);
INSERT INTO transfer_plant (tanggal_dikirim, no_dokumen, nama_barang, quantity_barang, outlet_penerima, outlet_pengirim, mod_incharge, uom, user_id)
VALUES( '10-07-2022', 'TRF10002', 'Wings', '12', 'Richeese Factory Jatiwaringin', 'Richeese Factory Hankam', 'dio', 'PAC', 4);
INSERT INTO transfer_plant (tanggal_dikirim, no_dokumen, nama_barang, quantity_barang, outlet_penerima, outlet_pengirim, mod_incharge, uom, user_id)
VALUES( '10-07-2022', 'TRF10003', 'Paha Bawah', '12', 'Richeese Factory Jatiwaringin', 'Richeese Factory Hankam', 'diki', 'PAC', 4);
