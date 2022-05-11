/* eslint-disable react/jsx-pascal-case */
/* eslint-disable no-undef */
import { Card, Col, Collapse, Input, Row } from 'antd'
import Form from 'antd/lib/form/Form'
import FormItem from 'antd/lib/form/FormItem';
import React, { Component } from 'react'
import { Model_DangKy } from '../../Model/DangKy';
import { GridStyle, HeaderString, InputStyle, LayoutFormat } from '../../Support/Constant';
import My_DatePicker from '../Form_Support/My_DatePicker';

const { Panel } = Collapse;

export default class DangKy_Search extends Component {

    constructor (props){
        super(props);
        this.state = {
            data: JSON.parse(JSON.stringify(Model_DangKy.DangKy))
        }
    }

    handleHoChange = e => {
        const searchModel = this.state.data;
        searchModel.ho = e.target.value;
        this.props.onChange(searchModel);
    }
    handleTenChange = e => {
        const searchModel = this.state.data;
        searchModel.ten = e.target.value;
        this.props.onChange(searchModel);
    }
    handleGioiTinhChange = e => {
        const searchModel = this.state.data;
        searchModel.gioiTinh = e.target.value;
        this.props.onChange(searchModel);
    }
    handleNgaySinhChange = e => {
        const searchModel = this.state.data;
        searchModel.ngaySinh = e;
        this.props.onChange(searchModel);
    }
    handleCMNDChange = e => {
        const searchModel = this.state.data;
        searchModel.cmnd = e.target.value;
        this.props.onChange(searchModel);
    }
    handleNoiSinhChange = e => {
        const searchModel = this.state.data;
        searchModel.noiSinh = e.target.value;
        this.props.onChange(searchModel);
    }
    handleNgayCapChange = e => {
        const searchModel = this.state.data;
        searchModel.ngayCap = e;
        this.props.onChange(searchModel);
    }
    handleNoiCapChange = e => {
        const searchModel = this.state.data;
        searchModel.noiCap = e.target.value;
        this.props.onChange(searchModel);
    }
    handleSDTChange = e => {
        const searchModel = this.state.data;
        searchModel.sdt = e.target.value;
        this.props.onChange(searchModel);
    }
    handleEmailChange = e => {
        const searchModel = this.state.data;
        searchModel.email = e.target.value;
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
                    <Panel header={<span>{HeaderString.signModal}</span>} key="1">
                        <Card>
                            <Card.Grid  hoverable={false} style={GridStyle}>
                                <Row>
                                    <Col span={LayoutFormat.ColLabel}>
                                        <FormItem>
                                            {Model_DangKy.Field.ho.name}
                                        </FormItem>
                                    </Col>
                                    <Col span={LayoutFormat.ColInput}>
                                        <FormItem>
                                            <Input onChange={this.handleHoChange} style={InputStyle} value={searchModel.ho}/>  
                                        </FormItem>
                                    </Col>
                                    <Col span={LayoutFormat.ColLabel} offset={LayoutFormat.ColOffset}>
                                        <FormItem>
                                            {Model_DangKy.Field.ten.name}
                                        </FormItem>
                                    </Col>
                                    <Col span={LayoutFormat.ColInput}>
                                        <FormItem>
                                            <Input style={InputStyle} onChange={this.handleTenChange} value={searchModel.ten}/>                                        
                                        </FormItem>
                                    </Col>
                                </Row>
                                <Row>
                                    <Col span={LayoutFormat.ColLabel}>
                                        <FormItem>
                                            {Model_DangKy.Field.gioiTinh.name}
                                        </FormItem>
                                    </Col>
                                    <Col span={LayoutFormat.ColInput}>
                                        <FormItem>
                                            <Input onChange={this.handleGioiTinhChange} style={InputStyle} value={searchModel.gioiTinh}/>  
                                        </FormItem>
                                    </Col>
                                    <Col span={LayoutFormat.ColLabel} offset={LayoutFormat.ColOffset}>
                                        <FormItem>
                                            {Model_DangKy.Field.ngaySinh.name}
                                        </FormItem>
                                    </Col>
                                    <Col span={LayoutFormat.ColInput}>
                                        <FormItem>
                                            <My_DatePicker  style={InputStyle} onChange={this.handleNgaySinhChange} value={searchModel.ngaySinh}/>                                        
                                        </FormItem>
                                    </Col>
                                </Row>
                                <Row>
                                    <Col span={LayoutFormat.ColLabel}>
                                        <FormItem>
                                            {Model_DangKy.Field.noiSinh.name}
                                        </FormItem>
                                    </Col>
                                    <Col span={LayoutFormat.ColInput}>
                                        <FormItem>
                                            <Input onChange={this.handleNoiSinhChange} style={InputStyle} value={searchModel.noiSinh}/>  
                                        </FormItem>
                                    </Col>
                                    <Col span={LayoutFormat.ColLabel} offset={LayoutFormat.ColOffset}>
                                        <FormItem>
                                            {Model_DangKy.Field.cmnd.name}
                                        </FormItem>
                                    </Col>
                                    <Col span={LayoutFormat.ColInput}>
                                        <FormItem>
                                            <Input  style={InputStyle} onChange={this.handleCMNDChange} value={searchModel.cmnd}/>                                        
                                        </FormItem>
                                    </Col>
                                </Row>
                                <Row>
                                    <Col span={LayoutFormat.ColLabel}>
                                        <FormItem>
                                            {Model_DangKy.Field.ngayCap.name}
                                        </FormItem>
                                    </Col>
                                    <Col span={LayoutFormat.ColInput}>
                                        <FormItem>
                                            <My_DatePicker onChange={this.handleNgayCapChange} style={InputStyle} value={searchModel.ngayCap}/>  
                                        </FormItem>
                                    </Col>
                                    <Col span={LayoutFormat.ColLabel} offset={LayoutFormat.ColOffset}>
                                        <FormItem>
                                            {Model_DangKy.Field.noiCap.name}
                                        </FormItem>
                                    </Col>
                                    <Col span={LayoutFormat.ColInput}>
                                        <FormItem>
                                            <Input  style={InputStyle} onChange={this.handleNoiCapChange} value={searchModel.noiCap}/>                                        
                                        </FormItem>
                                    </Col>
                                </Row>
                                <Row>
                                    <Col span={LayoutFormat.ColLabel}>
                                        <FormItem>
                                            {Model_DangKy.Field.sdt.name}
                                        </FormItem>
                                    </Col>
                                    <Col span={LayoutFormat.ColInput}>
                                        <FormItem>
                                            <Input onChange={this.handleSDTChange} style={InputStyle} value={searchModel.sdt}/>  
                                        </FormItem>
                                    </Col>
                                    <Col span={LayoutFormat.ColLabel} offset={LayoutFormat.ColOffset}>
                                        <FormItem>
                                            {Model_DangKy.Field.email.name}
                                        </FormItem>
                                    </Col>
                                    <Col span={LayoutFormat.ColInput}>
                                        <FormItem>
                                            <Input  style={InputStyle} onChange={this.handleEmailChange} value={searchModel.email}/>                                        
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

// const WrappedDangKy_Search= Wrapper({ name: 'DangKy_Search' })(DangKy_Search);
// export { WrappedDangKy_Search as DangKy_Search };
