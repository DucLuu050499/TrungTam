/* eslint-disable react/jsx-pascal-case */
import { Button, Col, notification, Row, Space, Table } from "antd";
import React, { Component } from "react";
import { search } from "../../Controller/Data_Service";
import { Model_DanhSachThiSinh } from "../../Model/DanhSachThiSinh";
import { ChangeFormateDate, HeaderString } from "../../Support/Constant";
import MasterLayout from "../Master_Layout";
import DanhSachThiSinh_Search from "./DanhSachThiSinh_Search";

const key = "list"

export class DanhSachThiSinh_Layout extends Component {
    constructor (props){
        super(props);
        const searchModel = JSON.parse(JSON.stringify(Model_DanhSachThiSinh.DanhSachThiSinh));
        this.state = {
            searchModel,
            selectedModel: [],
            dataSource:[],
            key: 1
        }
    }

    handleSearchClick = () => {
        if(this.state.searchModel.hoTen !== "" || this.state.searchModel.sdt !== "" || this.state.searchModel.cmnd !== "")
        Promise.all([search(this.state.searchModel, 'baithi')]).then(async result =>{
            if(result[0].length < 1)
                this.openNotification(0);
            else
                this.setState({
                    dataSource: result[0].map(m => {
                        return {
                            ...m,
                            key: m.maBaiThi,
                            ngayThi: ChangeFormateDate(m.ngayThi),
                        }
                    })
                })
        })
    }
    
    handleChangeSearchModel = (value) => {
        this.setState({
            searchModel: value
        })
    }

    handleUnForcus = () => {
        if(this.state.key === 1){
           this.setState({
               key : 2
           })
        }else{
            this.setState({
                key : 1
            })
        }
    }

    reloadPage = () => {
        const searchModel = JSON.parse(JSON.stringify(Model_DanhSachThiSinh.DanhSachThiSinh));
        this.setState({
            searchModel,
        })
        this.handleUnForcus();
    }

    openNotification = (value) => {
        if(value === 1){
            notification.open({
            key,
            message: 'Thành công',
            description: 'Dữ liệu đã được thêm vào.',
            });
        }else{
            notification.open({
                key,
                message: 'Thất bại',
                description: 'Không tìm thấy.',
            });
        }
    }

    view_DanhSachThiSinh = (key) => {
        const searchModel = this.state.searchModel;
        let x = 0;
        Model_DanhSachThiSinh.columns.forEach(e => {
            x += e.width
        });
        return(
            <div>
                <DanhSachThiSinh_Search value={searchModel} onChange={this.handleChangeSearchModel} key={key}/>
                <Row>
                    <Col>
                        <Space>
                            <Button type="primary" onClick={this.handleSearchClick}>{HeaderString.search}</Button>
                        </Space>
                    </Col>
                </Row>
                <Table dataSource={this.state.dataSource} columns={Model_DanhSachThiSinh.columns} bordered scroll={{ x: x }}/>
            </div>
        )
    };


    render() {
        return (
            <MasterLayout component={this.view_DanhSachThiSinh(this.state.key)} menu={"Tìm kiếm"} name={"Danh sách thí sinh"} subMenu={"DanhSachThiSinh"}/>
        );
    }
}

export default DanhSachThiSinh_Layout;
