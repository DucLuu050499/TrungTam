const DangKy = {
    cmnd: "",
    ho: "",
    ten: "",
    gioiTinh: "",
    ngaySinh: null,
    noiSinh: "",
    ngayCap: null,
    noiCap: "",
    sdt: "",
    email: "",
}
    
const Field = {
    ho: {name: "Họ", key: "ho"},
    ten: {name: "Tên", key: "ten"},
    gioiTinh: {name: "Giới tính", key: "gioiTinh"},
    ngaySinh: {name: "Ngày sinh", key: "ngaySinh"},
    noiSinh: {name: "Nơi sinh", key: "noiSinh"},
    cmnd: {name: "CMND/CCCD", key: "cmnd"},
    ngayCap: {name: "Ngày cấp", key: "ngayCap"},
    noiCap: {name: "Nơi cấp", key: "noiCap"},
    sdt: {name: "Số điện thoại", key: "sdt"},
    email: {name: "Email", key: "emai"},
}

const columns = Object.keys(Field).map(m => {
    const length = Object.keys(Field).length;
    return {
        title: Field[m].name,
        dataIndex: Field[m].key,
        key: Field[m].key,
        width: `${100/length}%`,
    }
})

const table_database = "thisinh";

export const Model_DangKy = {
    Field,
    DangKy,
    columns,
    table_database
}