import axios from '../utils/AxiosCustom'
const getListCourse = () =>{
    return  axios.get(`courses`);
}

export {getListCourse}