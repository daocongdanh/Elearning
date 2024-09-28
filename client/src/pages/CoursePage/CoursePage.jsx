
import { Link } from 'react-router-dom'
import { RatingComponent } from '../../components/RatingComponent/RatingComponent'
import { BoxVideoComponent } from '../../components/BoxVideoComponent/BoxVideoComponent'

const CoursePage = () => {
  return (
    <div className='bg-first py-8 text-white' >
        <div className='max-w-[1184px] mx-auto relative'>
            <div className='absolute z-50'>
                <BoxVideoComponent />
            </div>
            <div className='ml-4 max-w-[700px]'>
                <div className='text-fourth flex items-center gap-2 font-bold'>
                    <Link to="">Phát triển</Link>
                    <svg fill="#c0c4fc" height="10px" width="10px" version="1.1" viewBox="0 0 24 24" stroke="#c0c4fc">
                        <g>
                            <polygon points="6.8,23.7 5.4,22.3 15.7,12 5.4,1.7 6.8,0.3 18.5,12" />
                        </g>
                    </svg>
                    <Link to="">Ngôn ngữ lập trình</Link>
                    <svg fill="#c0c4fc" height="10px" width="10px" version="1.1" viewBox="0 0 24 24" stroke="#c0c4fc">
                        <g>
                            <polygon points="6.8,23.7 5.4,22.3 15.7,12 5.4,1.7 6.8,0.3 18.5,12" />
                        </g>
                    </svg>
                    <Link to="">Python</Link>
                </div>
                <h1 className='font-sans my-4'>Lập trình Python từ cơ bản đến nâng cao thông qua các dự án</h1>
                <p className='text-[19px]'>Lập trình Python từ cơ bản đến nâng cao thông qua các dự án với sự hỗ trợ của trí tuệ nhân tạo AI</p>
                <div className='flex gap-2 items-center'>
                    <div className='mt-2 mb-1 '>
                        <span className='bg-[#eceb98] text-first text-xs font-bold px-2 py-1'>Bán chạy nhất</span>
                    </div>
                    <RatingComponent show={true} colorNumberRank={"fourth"} colorNumberStar={"nineth"}/>
                    <span>463 học viên</span>
                </div>
                <div>
                    <span>Được tạo bởi <Link className='text-fourth underline'>Toan Bill</Link></span>
                </div>
                <div className='flex gap-1 items-center'>
                    <span>Lần cập nhật gần đây nhất 7/2024</span>
                    <svg className="mr-1"width="16px" height="16px" viewBox="0 0 25 25" fill="none" xmlns="http://www.w3.org/2000/svg" stroke="#ffffff">
                        <g id="SVGRepo_bgCarrier" stroke-width="0"/>
                        <g id="SVGRepo_tracerCarrier" strokeLinecap="round" stroke-linejoin="round"/>
                        <g id="SVGRepo_iconCarrier"> <path d="M5.5 16.5H19.5M5.5 8.5H19.5M4.5 12.5H20.5M12.5 20.5C12.5 20.5 8 18.5 8 12.5C8 6.5 12.5 4.5 12.5 4.5M12.5 4.5C12.5 4.5 17 6.5 17 12.5C17 18.5 12.5 20.5 12.5 20.5M12.5 4.5V20.5M20.5 12.5C20.5 16.9183 16.9183 20.5 12.5 20.5C8.08172 20.5 4.5 16.9183 4.5 12.5C4.5 8.08172 8.08172 4.5 12.5 4.5C16.9183 4.5 20.5 8.08172 20.5 12.5Z" stroke="#ffffff" stroke-width="1.2"/> </g>
                    </svg>
                    <span>Vietnamese</span>
                </div>
            </div>
        </div>
    </div>
  )
}

export default CoursePage