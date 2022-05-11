/* eslint-disable react/jsx-pascal-case */
/* eslint-disable no-undef */
import { Card, Col, Collapse, Input, Row } from 'antd'
import Form from 'antd/lib/form/Form'
import FormItem from 'antd/lib/form/FormItem';
import React, { Component } from 'react'
import { Model_ThongTinThiSinh } from '../../Model/ThongTinThiSinh';
import { GridStyle, HeaderString, InputStyle, LayoutFormat } from '../../Support/Constant';

const { Panel } = Collapse;

export default class ThongTinThiSinh_Search extends Component {

    constructor (props){
        super(props);
        this.state = {
            data: JSON.parse(JSON.stringify(Model_ThongTinThiSinh.ThongTinThiSinh))
        }
    }

    handleHoTenChange = e => {
        const searchModel = this.state.data;
        searchModel.hoTen = e.target.value;
        this.props.onChange(searchModel);
    }

    handleSDTChange = e => {
        const  searchModel = this.state.data;
        searchModel.sdt =  e.target.value;
        this.props.onChange(searchModel);
    }

    handleCMNDChange = e => {
        const  searchModel = this.state.data;
        searchModel.cmnd =  e.target.value;
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
                                            {Model_ThongTinThiSinh.Field.hoTen.name}
                                        </FormItem>
                                    </Col>
                                    <Col span={LayoutFormat.ColInput}>
                                        <FormItem>
                                            <Input style={InputStyle} onChange={this.handleHoTenChange} value={searchModel.hoTen}/>
                                        </FormItem>
                                    </Col>
                                    <Col span={LayoutFormat.ColLabel} offset={LayoutFormat.ColOffset}>
                                        <FormItem>
                                            {Model_ThongTinThiSinh.Field.sdt.name}
                                        </FormItem>
                                    </Col>
                                    <Col span={LayoutFormat.ColInput}>
                                        <FormItem>
                                            <Input style={InputStyle} onChange={this.handleSDTChange} value={searchModel.sdt}/>
                                        </FormItem>
                                    </Col>
                                </Row>
                                <Row>
                                    <Col span={LayoutFormat.ColLabel}>
                                        <FormItem>
                                            {Model_ThongTinThiSinh.Field.cmnd.name}
                                        </FormItem>
                                    </Col>
                                    <Col span={LayoutFormat.ColInput}>
                                        <FormItem>
                                            <Input style={InputStyle} onChange={this.handleCMNDChange} value={searchModel.cmnd}/>
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

// const WrappedThongTinThiSinh_Search= Wrapper({ name: 'ThongTinThiSinh_Search' })(ThongTinThiSinh_Search);
// export { WrappedThongTinThiSinh_Search as ThongTinThiSinh_Search };
