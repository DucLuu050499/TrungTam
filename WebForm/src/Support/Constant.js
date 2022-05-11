import {
	CustomerServiceOutlined,
	CarOutlined,
	AccountBookOutlined,
} from '@ant-design/icons';

export const Menu_List = [
	{name: "Đăng ký", icon: <CarOutlined />, view: [{name: "Đăng ký", key: "DangKy"}]},
	{name: "Tìm kiếm", icon: <CustomerServiceOutlined />, view: [{name: "Thông tin thí sinh", key: "ThongTinThiSinh"}, {name: "Chứng nhận", key: "ChungNhan"},  {name: "Danh sách thí sinh", key: "DanhSachThiSinh"}]},
	{name: "Thống kê", icon: <AccountBookOutlined /> , view: [{name: "Thống kê", key: "ThongKe"}]}
]
export const LayoutFormat = {
    ColLabel: 4,
    ColInput: 7,
	ColOffset: 2,
    ColCardLabel: 8,
    ColCardInput: 16,
};

export const HeaderString = {
    sign: "Đăng ký",
    signModal: "Thông tin đăng ký",
	searchModal: "Thông tin tìm kiếm",
    search: "Tìm kiếm",
	create: "Thêm mới",
	view: "Xem",
	edit: "Chỉnh sửa",
	delete: "Xóa",
	hide: "Hủy hiển thị"

};

export const GridStyle = {
	width: '100%',
};
export const InputStyle = {
   width: '100%',
}
export const APIServer = "http://localhost:8080/"
//export const APIServer = "http://14.176.204.153:8083/"
export const dateTimeReviver = function (key, value) {
    var a;
    if (typeof value === 'string') {
        a = /\/Date\((\d*)\)\//.exec(value);
        if (a) {
            return new Date(+a[1]);
        }
    }
    return value;
}

export const ChangeFormateDate = (oldDate) =>
{
   return oldDate.toString().split("-").reverse().join("-");
}