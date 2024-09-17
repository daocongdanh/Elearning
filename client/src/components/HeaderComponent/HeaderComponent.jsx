import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import { ButtonComponent } from '../ButtonComponent/ButtonComponent'
import SubMenu from '../SubMenu/SubMenu';
import { getCatagories } from '../../services/categories';
import { DropDownMenu } from '../DropDownMenu/DropDownMenu';
import { useTranslation } from 'react-i18next';
import { ModelChoiceLanguage } from '../Models/ModelChoiceLanguage';
import { BoxContent } from '../BoxContent/BoxContent';
import { BoxCartCourse } from '../BoxContent/BoxCartCourse';
const HeaderComponent = ({isOpenMoDel,setIsOpenModel}) => {
    const { t } = useTranslation();
    const [isOpen, setIsOpen] = useState(false);
    const [isHovered,setIsHovered] = useState("");
    const [categories, setCategories] = useState({
        level1: [],
        level2: [],
        level3: []
    });
    const fectCategoti = async()=>{
        const res1 = await getCatagories(1);
        const res2 = await getCatagories(2);
        const res3 = await getCatagories(3);
        if (res1?.status === 200 && res2?.status === 200 && res3?.status === 200) {
            const updatedCategories = {
                level1: res1.data,
                level2: res2.data,
                level3: res3.data 
            };

            setCategories(updatedCategories);
        }
    }
    const handleMouseOver = (e) => {
        setIsHovered(e);
      };
    
      const handleMouseLeave = () => {
        setIsHovered("");
      };
    useEffect(() => {
        fectCategoti();
        if (isOpen || isOpenMoDel) {
        document.body.style.overflow = 'hidden';
            } else {
            document.body.style.overflow = '';
        }

        return () => {
        document.body.style.overflow = '';
        };
    }, [isOpen,isOpenMoDel]);
  return (
    <div className="flex items-center h-[72px] px-6 relative z-10 shadow-md shadow-[#00000059] tabletXs:justify-between">
        <ModelChoiceLanguage isOpenMoDel={isOpenMoDel} setIsOpenModel={setIsOpenModel}/>
        <button data-collapse-toggle="navbar-default" onClick={()=>setIsOpen(true)} className=" hidden tabletXs:block">
            <svg fill="#000000" width="45px" height="45px" viewBox="-8 0 32 32" version="1.1" xmlns="http://www.w3.org/2000/svg">
                <title>{t('Thể loại')}</title>
                <path d="M15.4 12.6h-14.56c-0.48 0-0.84-0.36-0.84-0.84s0.36-0.84 0.84-0.84h14.52c0.48 0 0.84 0.36 0.84 0.84 0.040 0.44-0.36 0.84-0.8 0.84zM15.4 16.84h-14.56c-0.48 0-0.84-0.36-0.84-0.84s0.36-0.84 0.84-0.84h14.52c0.48 0 0.84 0.36 0.84 0.84s-0.36 0.84-0.8 0.84zM15.4 21.080h-14.56c-0.48 0-0.84-0.36-0.84-0.84s0.36-0.84 0.84-0.84h14.52c0.48 0 0.84 0.36 0.84 0.84s-0.36 0.84-0.8 0.84z"></path>
            </svg>
        </button>
        <SubMenu categories={categories} setIsOpen={setIsOpen} isOpen={isOpen}/>
        <Link to="/" className='pr-2'><img src="/assets/logos/logo.svg" className='w-[91px] tablet:w-[75px]' alt="" /></Link>
        <div className='relative h-full flex items-center tabletXs:hidden' onMouseOver={()=>handleMouseOver(t('Thể loại'))} onMouseLeave={()=>handleMouseLeave()}>
            <li className={`cursor-pointer ${isHovered===t('Thể loại') ? 'text-eighth' : ''}`} >
                {t('Thể loại')}
            </li>
            <div className={`${isHovered===t('Thể loại')?"block": "hidden"} absolute top-full z-0 `}>
                <DropDownMenu categories={categories}/>
            </div>
        </div>
        <form className="grow px-3 tabletXs:hidden">   
            <div className="relative">
                <div className="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
                    <svg width="24px" height="24px" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path fillRule="evenodd" clipRule="evenodd" d="M15 10.5C15 12.9853 12.9853 15 10.5 15C8.01472 15 6 12.9853 6 10.5C6 8.01472 8.01472 6 10.5 6C12.9853 6 15 8.01472 15 10.5ZM14.1793 15.2399C13.1632 16.0297 11.8865 16.5 10.5 16.5C7.18629 16.5 4.5 13.8137 4.5 10.5C4.5 7.18629 7.18629 4.5 10.5 4.5C13.8137 4.5 16.5 7.18629 16.5 10.5C16.5 11.8865 16.0297 13.1632 15.2399 14.1792L20.0304 18.9697L18.9697 20.0303L14.1793 15.2399Z" fill="#080341"/>
                    </svg>
                </div>
                <input type="search" className="block w-full h-12 ps-10 text-sm text-gray-900 border border-black rounded-full bg-third focus:border-black focus:ring-0"  placeholder={t("Tìm kiếm nội dung bất kì")} required />
            </div>
        </form>
        <div className='relative h-full flex items-center' onMouseOver={()=>handleMouseOver(t("Udemy Business"))} onMouseLeave={()=>handleMouseLeave()}>
            <Link to="/business" className='px-3 hover:text-eighth labMd:hidden'>{t("Udemy Business")}</Link>
            <div className={`absolute top-full right-0 ${isHovered===t('Udemy Business')?"block":"hidden"}`}>
                <div className="w-72 mt-1">
                    <BoxContent h1={t("Cho phép nhóm của bạn truy cập vào hơn 27.000 khóa học hàng đầu của Udemy, ở mọi nơi và mọi lúc.")} textBn={t("Dùng thử Udemy Business")} center={true} sizeH1={"19"}/>
                </div>
            </div>
        </div>
        <div className='relative h-full flex items-center' onMouseOver={()=>handleMouseOver(t('Giảng dạy trên Udemy'))} onMouseLeave={()=>handleMouseLeave()}>
            <Link to="/teaching" className='px-3 hover:text-eighth tablet:hidden'>{t('Giảng dạy trên Udemy')}</Link>
            <div className={`absolute top-full right-0 ${isHovered===t('Giảng dạy trên Udemy')?"block":"hidden"}`}>
                <div className="w-72 mt-1">
                    <BoxContent h1={t("Biến kiến thức của bạn thành cơ hội và tiếp cận với hàng triệu người trên thế giới.")} textBn={t("Tìm hiểu thêm")} center={true} sizeH1={"19"}/>
                </div>
            </div>
        </div>
        {/* <Link to="/instructor/courses" className='px-3 hover:text-eighth'>Giảng viên</Link>
        <Link to="/home/my-courses/learning" className='px-3 hover:text-eighth'>Học tập</Link> */}
        {/* <Link to="/my-courses/wishlist" className='px-3 hover:text-eighth'>
            <svg className="w-6 h-6 text-gray-800 hover:text-eighth" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24">
                <path stroke="currentColor" strokeLinecap="round" stroke-linejoin="round" stroke-width="2" d="M12.01 6.001C6.5 1 1 8 5.782 13.001L12.011 20l6.23-7C23 8 17.5 1 12.01 6.002Z"/>
            </svg>
        </Link> */}
        <div className='flex h-full'>
            <button to="/cart" className='px-3 hidden tabletXs:block'>
                <svg width="24px" height="24px" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path fillRule="evenodd" clipRule="evenodd" d="M15 10.5C15 12.9853 12.9853 15 10.5 15C8.01472 15 6 12.9853 6 10.5C6 8.01472 8.01472 6 10.5 6C12.9853 6 15 8.01472 15 10.5ZM14.1793 15.2399C13.1632 16.0297 11.8865 16.5 10.5 16.5C7.18629 16.5 4.5 13.8137 4.5 10.5C4.5 7.18629 7.18629 4.5 10.5 4.5C13.8137 4.5 16.5 7.18629 16.5 10.5C16.5 11.8865 16.0297 13.1632 15.2399 14.1792L20.0304 18.9697L18.9697 20.0303L14.1793 15.2399Z" fill="#080341"/>
                </svg>
            </button>
            <div className='relative h-full flex items-center' onMouseOver={()=>handleMouseOver(t('Giỏ hàng'))} onMouseLeave={()=>handleMouseLeave()}>
                <Link to="/cart" className='px-3'>
                    <svg className="clipRule24px] h-[24px] text-gray-800 hover:text-eighth" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24">
                        <path stroke="currentColor" strokeLinecap="round" stroke-linejoin="round" stroke-width="2" d="M5 4h1.5L9 16m0 0h8m-8 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4Zm8 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4Zm-8.5-3h9.25L19 7H7.312"/>
                    </svg>
                </Link>
                <div className={`absolute top-full right-0 ${isHovered===t('Giỏ hàng')?"block":"hidden"}`}>
                    <div className="w-72 mt-1">
                        <BoxCartCourse/>
                    </div>
                </div>
            </div>
            

        </div>
        <Link to="/login" className='ml-2 tabletXs:hidden'>
            <ButtonComponent padding={3} text={t('Đăng nhập')} hover={true} bold={true}/>
        </Link>
        <Link to="/register" className='ml-2 tabletXs:hidden'>
            <ButtonComponent padding={3} text={t("Đăng ký")} bold={true} textColor={"white"} colorBg={"first"}/>
        </Link>
        {/* <Link to="/instructor/user/view-notifications" className="px-3">
            <svg className="w-[24px] h-[24px] text-gray-800 hover:text-eighth" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24">
                <path stroke="currentColor" strokeLinecap="round" stroke-linejoin="round" stroke-width="2" d="M12 5.365V3m0 2.365a5.338 5.338 0 0 1 5.133 5.368v1.8c0 2.386 1.867 2.982 1.867 4.175 0 .593 0 1.292-.538 1.292H5.538C5 18 5 17.301 5 16.708c0-1.193 1.867-1.789 1.867-4.175v-1.8A5.338 5.338 0 0 1 12 5.365ZM8.733 18c.094.852.306 1.54.944 2.112a3.48 3.48 0 0 0 4.646 0c.638-.572 1.236-1.26 1.33-2.112h-6.92Z"/>
            </svg>
        </Link> */}
        <li onClick={()=>setIsOpenModel(true)} className='ml-2 cursor-pointer flex h-10 justify-center items-center w-10 border-first border-solid border font-bold hover:bg-[#1739531f] tabletXs:hidden'>
            <svg className="w-[24px] h-[24px] text-gray-800 " width="24" height="24" viewBox="0 0 25 25" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path d="M5.5 16.5H19.5M5.5 8.5H19.5M4.5 12.5H20.5M12.5 20.5C12.5 20.5 8 18.5 8 12.5C8 6.5 12.5 4.5 12.5 4.5M12.5 4.5C12.5 4.5 17 6.5 17 12.5C17 18.5 12.5 20.5 12.5 20.5M12.5 4.5V20.5M20.5 12.5C20.5 16.9183 16.9183 20.5 12.5 20.5C8.08172 20.5 4.5 16.9183 4.5 12.5C4.5 8.08172 8.08172 4.5 12.5 4.5C16.9183 4.5 20.5 8.08172 20.5 12.5Z" stroke="#121923" stroke-width="1.2"/>
            </svg>
        </li>
        {/* <Link to="/instructor/profile/basic-information" className="h-12 w-12"></Link> */}
    </div>
  )
}

export default HeaderComponent