/* eslint-disable react/jsx-pascal-case */
import { Button, Card, Col, notification, Row, Space } from "antd";
import Meta from "antd/lib/card/Meta";
import React, { Component } from "react";
import { useLocation } from "react-router";
import { search } from "../../Controller/Data_Service";
import { HeaderString } from "../../Support/Constant";
import MasterLayout from "../Master_Layout";
import ChungNhan_Search from "./ChungNhan_Search";

const key = "list"

 class ChungNhan extends Component {
    constructor (props){
        super(props);
        const searchModel = JSON.parse(JSON.stringify({sbd: ""}));
        this.state = {
            searchModel,
            selectedModel: [],
            dataSource: props.data !== undefined && !!props.data ? props.data : [],
            key: 1,
        }
    }

    handleSearchClick = () => {
        if(this.state.searchModel.sbd !== undefined && this.state.searchModel !== "")
        Promise.all([search(this.state.searchModel, 'baithi')]).then(async result =>{
            if(result[0].length < 1)
                this.openNotification(0);
            else{
                const dataSource = result[0].filter(f => f.sbd === this.state.searchModel.sbd);
                this.setState({
                    dataSource: dataSource,
                });
            }
        });
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
        const searchModel = JSON.parse(JSON.stringify({sbd: ""}));
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

    view_ChungNhan = (key) => {
        const searchModel = this.state.searchModel;
        return(
            <div>
                <ChungNhan_Search value={searchModel} onChange={this.handleChangeSearchModel} key={key}/>
                <Row>
                    <Col>
                        <Space>
                            <Button type="primary" onClick={this.handleSearchClick}>{HeaderString.search}</Button>
                        </Space>
                    </Col>
                </Row>
                {this.state.dataSource.length > 0  ? (<Card
                    hoverable
                    style={{ width: 400 }}
                    cover={<img alt="example" src={require ("./Certificate_Template_PNG_Image.png")} />}
                >
                    <Meta title={this.state.dataSource[0].hoTen} description={this.state.dataSource[0].ngayThi} />
                </Card>) : ""}
            </div>
        )
    };


    render() {
        return (
            <MasterLayout component={this.view_ChungNhan(this.state.key)} menu={"Tìm kiếm"} name={"Chứng nhận"} subMenu={"ChungNhan"}/>
        );
    }
}

function ChungNhan_Layout(){
    let location = useLocation();
    let data = [];
    if(location.search !== undefined && location.search !== ""){
        const text = decodeURI(`${location.search}`.slice(1));
        data = [JSON.parse(text)];

    }
    return(
        <ChungNhan data={data}/>
    )
};

export default ChungNhan_Layout;
