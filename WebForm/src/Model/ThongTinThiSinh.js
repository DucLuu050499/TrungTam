const ThongTinThiSinh = {
    hoTen: "",
    sdt: "",
    cmnd: "",
}
    
const Field = {
    hoTen: {name: "Họ tên", key: "hoTen"},
    cmnd: {name: "CMND/CCCD", key: "cmnd"},
    sdt: {name: "Số điện thoại", key: "sdt"},
}

const columns = [
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
        title: "Phòng thi",
        dataIndex: 'tenPhongThi',
        width: "10%",
    },
    {
        title: "Ngày thi",
        dataIndex: 'ngayThi',
        width: "10%"
    },
    {
        title: "Ca thi",
        dataIndex: 'caThi',
        width: '10%'
    },
    {
        title: "Điểm nghe",
        dataIndex: 'diemNghe',
        width: "10%"
    },
    {
        title: "Điểm nói",
        dataIndex: 'diemNoi',
        width: "10%"
    },
    {
        title: "Điểm đọc",
        dataIndex: 'diemDoc',
        width: "10%"
    },
    {
        title: "Điểm viết",
        dataIndex: 'diemViet',
        width: "10%"
    },
]



export const Model_ThongTinThiSinh = {
    Field,
    ThongTinThiSinh,
    columns,
}