import axios from '../utils/AxiosCustom'
const getCatagories = (level) =>{
    return  axios.get(`categories/level/${level}`);
}
export {getCatagories}