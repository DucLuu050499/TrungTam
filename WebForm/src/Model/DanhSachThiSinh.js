import { Link } from "react-router-dom"

const DanhSachThiSinh = {
    maKhoaThi: -1,
    maPhongThi: -1,
}
    
const Field = {
    khoaThi: {name: "Khóa thi", key: "khoaThi"},
    phongThi: {name: "Phòng thi", key: "phongThi"},
}

const columns = [
    {
        title: "Phòng thi",
        dataIndex: 'tenPhongThi',
        width: "10%",
    },
    {
        title: "Số báo danh",
        dataIndex: 'sbd',
        width: "15%",
    },
    {
        title: "Họ tên",
        dataIndex: 'hoTen',
        width: "15%",
    },
    {
        title: "Thông tin chi tiết",
        dataIndex: '',
        width: "20%",
        render: (text, record) => <Link
        to={{
            pathname: "/thongtinthisinh",
            search: JSON.stringify(record),
          }}
      >
        Thông tin
      </Link>
    },
    {
        title: "Chứng nhận",
        dataIndex: '',
        width: "20%",
        render: (text, record) => <Link
        to={{
            pathname: "/chungnhan",
            search: JSON.stringify(record),
          }}
      >
        Chứng nhận
      </Link>
    },
]



export const Model_DanhSachThiSinh = {
    Field,
    DanhSachThiSinh,
    columns,
}