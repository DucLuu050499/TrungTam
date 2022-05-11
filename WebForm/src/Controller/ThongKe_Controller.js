import { search } from "./Data_Service"

export const thongKe = async () =>{
    const arrKhoaThi = await search({}, 'khoathi');
    const arrTrinhDo = await search({}, 'trinhdo');
    const arrPhongThi = await search({}, 'phongthi');
    const arrThiSinh = await search({}, 'thisinhduthi');

    const trinhDo = [...new Set(arrTrinhDo.map(m => {
        const phongThi = [...new Set(arrPhongThi.filter(f => f.maTrinhDo === m.maTrinhDo))];
        const khoaThi = [...new Set(arrKhoaThi.filter(f => !!phongThi.find(pt => pt.maKhoaThi === f.maKhoaThi)))];
        const thiSinh = [...new Set(arrThiSinh.filter(f => !!phongThi.find(pt => pt.maPhongThi === f.maPhongThi)))];

        return{
            trinhDo: m.tenTrinhDo,
            khoaThi: khoaThi.length,
            phongThi: phongThi.length,
            thiSinh: thiSinh.length,
        }
    }))];

    return trinhDo;
}