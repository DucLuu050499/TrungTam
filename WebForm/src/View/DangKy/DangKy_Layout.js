/* eslint-disable react/jsx-pascal-case */
import { Button, Col, notification, Row, Space } from "antd";
import React, { Component } from "react";
import { create_model } from "../../Controller/Data_Service";
import { Model_DangKy } from "../../Model/DangKy";
import { HeaderString } from "../../Support/Constant";
import MasterLayout from "../Master_Layout";
import DangKy_Search from "./DangKy_Search";

const key ='search';

export class DangKy_Layout extends Component {
    constructor (props){
        super(props);
        const searchModel = JSON.parse(JSON.stringify(Model_DangKy.DangKy));
        this.state = {
            searchModel,
            count: 0,
            key: 1
        }
    }
    
    handleChangeSignModel = (value) => {
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
    handleSignClick = () => {
        Promise.all([create_model(this.state.searchModel, Model_DangKy.table_database)]).then(rs => {
            this.openNotification(rs[0]);
            this.clearInput();
        });
    }
    clearInput = () =>{
        this.setState({
            searchModel: JSON.parse(JSON.stringify(Model_DangKy.DangKy))
        })
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
                description: 'Dữ liệu không được thêm vào.',
            });
        }
        this.props.onAdd();
    }

    view_diadiem = (key) => {
        const searchModel = this.state.searchModel;
        return(
            <div>
                <DangKy_Search value={searchModel} onChange={this.handleChangeSignModel} key={key}/>
                <Row>
                    <Col>
                        <Space>
                            <Button type="primary" onClick={this.handleSignClick}>{HeaderString.sign}</Button>
                        </Space>
                    </Col>
                </Row>
            </div>
        )
    };


    render() {
        return (
            <MasterLayout component={this.view_diadiem(this.state.key)} menu={"Đăng ký"} name={"Đăng ký"} subMenu={"DangKy"}/>
        );
    }
}

export default DangKy_Layout;
