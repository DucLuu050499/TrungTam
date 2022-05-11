/* eslint-disable react/jsx-pascal-case */
import React, { Component } from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import DangKy_Layout from './View/DangKy/DangKy_Layout';
import MasterLayout from './View/Master_Layout';
import ThongTinThiSinh_Layout from './View/ThongTinThiSinh/ThongTinThiSinh_Layout';
import DanhSachThiSinh_Layout from './View/DanhSachThiSinh/DanhSachThiSinh_Layout';
import DanhSachChungNhan_Layout from './View/ChungNhan/ChungNhan_Layout';
import ThongKe_Layout from './View/ThongKe/ThongKe_Layout';


export class RouterApp extends Component {
    render() {
        return (
            <div>
                <BrowserRouter>
                    <Routes>
                        <Route path="/" element={<MasterLayout component={(<div></div>)} />} />
                        <Route path="dangky" element={<DangKy_Layout />} />
                        <Route path="thongtinthisinh" element={<ThongTinThiSinh_Layout />} />
                        <Route path="danhsachthisinh" element={<DanhSachThiSinh_Layout />} />
                        <Route path="chungnhan" element={<DanhSachChungNhan_Layout />} />
                        <Route path="thongke" element={<ThongKe_Layout />} />
                    </Routes>
                </BrowserRouter>
            </div>
        )
    }
}

export default RouterApp
