/* eslint-disable react/jsx-pascal-case */
import { Button, Col, notification, Row, Space, Table } from "antd";
import React, { Component } from "react";
import { useLocation } from "react-router";
import { search } from "../../Controller/Data_Service";
import { Model_ThongTinThiSinh } from "../../Model/ThongTinThiSinh";
import { ChangeFormateDate, HeaderString } from "../../Support/Constant";
import MasterLayout from "../Master_Layout";
import ThongTinThiSinh_Search from "./ThongTinThiSinh_Search";

const key = "list";


export class ThongTinThiSinh extends Component {
    constructor (props){  
        super(props);
        const searchModel = JSON.parse(JSON.stringify(Model_ThongTinThiSinh.ThongTinThiSinh));
        this.state = {
            searchModel,
            selectedModel: [],
            dataSource: props.data !== undefined && !!props.data ? props.data : [],
            key: 1
        }
        console.log(props.data);
    }

    componentDidMount(){
        this.setState({
            dataSource: this.state.dataSource.map(m => {
                return {
                    ...m,
                    key: m.maBaiThi,
                    ngayThi: ChangeFormateDate(m.ngayThi),
                }
            })
        })
    }

    handleSearchClick = () => {
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
        const searchModel = JSON.parse(JSON.stringify(Model_ThongTinThiSinh.ThongTinThiSinh));
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

    view_ThongTinThiSinh = (key) => {
        const searchModel = this.state.searchModel;
        let x = 0;
        Model_ThongTinThiSinh.columns.forEach(e => {
            x += e.width
        });
        return(
            <div>
                <ThongTinThiSinh_Search value={searchModel} onChange={this.handleChangeSearchModel} key={key}/>
                <Row>
                    <Col>
                        <Space>
                            <Button type="primary" onClick={this.handleSearchClick}>{HeaderString.search}</Button>
                        </Space>
                    </Col>
                </Row>
                <Table dataSource={this.state.dataSource} columns={Model_ThongTinThiSinh.columns} bordered scroll={{ x: x }}/>
            </div>
        )
    };


    render() {
        return (
            <MasterLayout component={this.view_ThongTinThiSinh(this.state.key)} menu={"Tìm kiếm"} name={"Thông tin thí sinh"} subMenu={"ThongTinThiSinh"}/>
        );
    }
}

function ThongTinThiSinh_Layout(){
    let location = useLocation();
    let data = [];
    if(location.search !== undefined && location.search !== ""){
        const text = decodeURI(`${location.search}`.slice(1));
        data = [JSON.parse(text)];

    }
    return(
        <ThongTinThiSinh data={data}/>
    )
};

export default ThongTinThiSinh_Layout;
