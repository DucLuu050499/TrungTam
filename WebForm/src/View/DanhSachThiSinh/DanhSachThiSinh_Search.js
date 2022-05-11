/* eslint-disable react/jsx-pascal-case */
/* eslint-disable no-undef */
import { Card, Col, Collapse, Row } from 'antd'
import Form from 'antd/lib/form/Form'
import FormItem from 'antd/lib/form/FormItem';
import React, { Component } from 'react'
import { Model_DanhSachThiSinh } from '../../Model/DanhSachThiSinh';
import { GridStyle, HeaderString, InputStyle, LayoutFormat } from '../../Support/Constant';
import KhoaThi_Select from '../KhoaThi/KhoaThi_Select';
import PhongThi_Select from '../PhongThi/PhongThi_Select';

const { Panel } = Collapse;

export default class DanhSachThiSinh_Search extends Component {

    constructor (props){
        super(props);
        this.state = {
            data: JSON.parse(JSON.stringify(Model_DanhSachThiSinh.DanhSachThiSinh))
        }
    }

    handleKhoaThiChange = e => {
        const searchModel = this.state.data;
        searchModel.maKhoaThi = e;
        this.props.onChange(searchModel);
    }

    handlePhongThiChange = e => {
        const  searchModel = this.state.data;
        searchModel.maPhongThi =  e;
        this.props.onChange(searchModel);
    }

    render() {
        const searchModel = this.state.data;
        const formItemLayout = {
            labelCol: {
                xs: { span: 24 },
                sm: { span: 22 },
            },
            wrapperCol: {
                xs: { span: 24 },
                sm: { span: 22 },
            },
        };
        return (
            <Form {...formItemLayout}>
                <Collapse
                    defaultActiveKey={["1"]}
                    expandIconPosition={"right"}
                >
                    <Panel header={<span>{HeaderString.searchModal}</span>} key="1">
                        <Card>
                            <Card.Grid  hoverable={false} style={GridStyle}>
                                <Row>
                                    <Col span={LayoutFormat.ColLabel}>
                                        <FormItem>
                                            {Model_DanhSachThiSinh.Field.khoaThi.name}
                                        </FormItem>
                                    </Col>
                                    <Col span={LayoutFormat.ColInput}>
                                        <FormItem>
                                            <KhoaThi_Select style={InputStyle} onChange={this.handleKhoaThiChange} value={searchModel.maKhoaThi}/>
                                        </FormItem>
                                    </Col>
                                    <Col span={LayoutFormat.ColLabel} offset={LayoutFormat.ColOffset}>
                                        <FormItem>
                                            {Model_DanhSachThiSinh.Field.phongThi.name}
                                        </FormItem>
                                    </Col>
                                    <Col span={LayoutFormat.ColInput}>
                                        <FormItem>
                                            <PhongThi_Select style={InputStyle} onChange={this.handlePhongThiChange} value={searchModel.maPhongThi} maKhoaThi={searchModel.maKhoaThi}/>
                                        </FormItem>
                                    </Col>
                                </Row>
                            </Card.Grid>
                        </Card>
                    </Panel>
                </Collapse>
            </Form>
        )
    }
}

// const WrappedDanhSachThiSinh_Search= Wrapper({ name: 'DanhSachThiSinh_Search' })(DanhSachThiSinh_Search);
// export { WrappedDanhSachThiSinh_Search as DanhSachThiSinh_Search };
