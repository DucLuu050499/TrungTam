/* eslint-disable react/jsx-pascal-case */
/* eslint-disable no-undef */
import { Card, Col, Collapse, Input, Row } from 'antd'
import Form from 'antd/lib/form/Form'
import FormItem from 'antd/lib/form/FormItem';
import React, { Component } from 'react'
import { Model_ThongTinThiSinh } from '../../Model/ThongTinThiSinh';
import { GridStyle, HeaderString, InputStyle, LayoutFormat } from '../../Support/Constant';

const { Panel } = Collapse;

export default class ChungNhan_Search extends Component {

    constructor (props){
        super(props);
        this.state = {
            data: JSON.parse(JSON.stringify(Model_ThongTinThiSinh.ThongTinThiSinh))
        }
    }

    handleSBDChange = e => {
        const searchModel = this.state.data;
        searchModel.sbd = e.target.value;
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
                                            {"Số báo danh"}
                                        </FormItem>
                                    </Col>
                                    <Col span={LayoutFormat.ColInput}>
                                        <FormItem>
                                            <Input style={InputStyle} onChange={this.handleSBDChange} value={searchModel.sbd}/>
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

// const WrappedChungNhan_Search= Wrapper({ name: 'ChungNhan_Search' })(ChungNhan_Search);
// export { WrappedChungNhan_Search as ChungNhan_Search };
