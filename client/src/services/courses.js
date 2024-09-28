import axios from '../utils/AxiosCustom'
const getDetailCourse = (id) =>{
    return  axios.get(`courses/${id}`);
}
const getListCourse = () =>{
    return  axios.get(`courses`);
}

export {getListCourse,getDetailCourse}