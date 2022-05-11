/* eslint-disable react/jsx-pascal-case */
import { Table } from "antd";
import React, { Component } from "react";
import { thongKe } from "../../Controller/ThongKe_Controller";
import MasterLayout from "../Master_Layout";


const col = [ 
    {
        title: "Trình đô",
        dataIndex: 'trinhDo',
        width: "25%",
    },
    {
        title: "Khóa thi",
        dataIndex: 'khoaThi',
        width: "25%",
        sorter: (a, b) => a.khoaThi - b.khoaThi,
    },
    {
        title: "Phòng thi",
        dataIndex: 'phongThi',
        width: "25%",
        sorter: (a, b) => a.phongThi - b.phongThi,
    },
    {
        title: "Thí sinh",
        dataIndex: 'thiSinh',
        width: "25%",
        sorter: (a, b) => a.thiSinh - b.thiSinh,
    },
]
export class ThongKe_Layout extends Component {
    constructor (props){
        super(props);
        this.state = {
            data:[],
        }
    }

    componentDidMount(){
        Promise.all([thongKe()]).then(rs => {
            this.setState({
                data : rs[0].map(m => {
                    return{
                        ...m,
                        key: m.trinhDo
                    }
                })
            })
        })
    }

    view = () => {


        return(
            <Table columns={col} dataSource={this.state.data}/>
        );
    }

    render() {
        return (
            <MasterLayout component={this.view()} menu={"Thống kê"} name={"Thống kê"} subMenu={"ThongKe"}/>
        );
    }
}

export default ThongKe_Layout;
