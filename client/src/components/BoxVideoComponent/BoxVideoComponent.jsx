import React, { useState } from 'react'
import { ButtonComponent } from '../ButtonComponent/ButtonComponent';
import { useTranslation } from 'react-i18next';
import { ModelPlayVideo } from '../Models/ModelPlayVideo';
export const BoxVideoComponent = () => {
    const [openModal, setOpenModal] = useState(false)
    const {t} = useTranslation()
  return (
    <div className='bg-white'>
        <ModelPlayVideo openModal={openModal} setOpenModal={setOpenModal}/>
        <div className='w-[340px] relative'>
            <img src="assets/imgs/img2.jpg" alt="" />
            <div className='absolute top-[32%] w-full flex flex-col items-center gap-3'>
                <button className='bg-first rounded-full ' onClick={() => setOpenModal(true)}>
                    <svg
                        fill="#ffffff"
                        height="64px"
                        width="64px"
                        viewBox="0 0 490.718 490.718"
                        stroke="#ffffff"
                        >
                        <g id="SVGRepo_bgCarrier" strokeWidth="0" />
                        <g id="SVGRepo_tracerCarrier" strokeLinecap="round" strokeLinejoin="round" />
                        <g id="SVGRepo_iconCarrier">
                            <g>
                            <path d="M245.359,0.359C109.852,0.359,0,110.049,0,245.358s109.852,245,245.359,245s245.359-109.691,245.359-245 S380.866,0.359,245.359,0.359z M176.828,341.011V140.824l187.489,100.098L176.828,341.011z" />
                            </g>
                        </g>
                    </svg>  
                </button>
                <p className='text-lg  font-bold'>{t("Xem trước khóa học này")}</p>
            </div>
        </div>
        <div className='p-6 text-first'>
            <span className='text-[32px]'>₫&nbsp;399.000</span>
            <div>
                <div>
                    <ButtonComponent text={t("Không hoạt động")} notHover={true} cursor={"cursor-not-allowed"} bold={true} height={"h-12"} textColor={"white"} colorBg={"eighth"} fullScreen={true}/>
                </div>
                <div>
                    <ButtonComponent text={t("Mua ngay")} bold={true} height={"h-12"} hover={true} fullScreen={true}/>
                </div>
            </div>
            <span>{t("Đảm bảo hoàn tiền trong 30 ngày")}</span>
            <ul className='text-first'>
                <h3>{t("Khóa học này bao gồm:")}</h3>
                <li>
                    <svg fill="#000000" width="800px" height="800px" viewBox="0 -6 46 46" xmlns="http://www.w3.org/2000/svg">
                        <path id="_24.TV" data-name="24.TV" d="M46,37H2a1,1,0,0,1-1-1V8A1,1,0,0,1,2,7H46a1,1,0,0,1,1,1V36A1,1,0,0,1,46,37ZM45,9H3V35H45ZM21,16a.975.975,0,0,1,.563.2l7.771,4.872a.974.974,0,0,1,.261,1.715l-7.974,4.981A.982.982,0,0,1,21,28a1,1,0,0,1-1-1V17A1,1,0,0,1,21,16ZM15,39H33a1,1,0,0,1,0,2H15a1,1,0,0,1,0-2Z" transform="translate(-1 -7)" fill-rule="evenodd"/>
                    </svg>
                    <span>18 giờ video theo yêu cầu</span>
                </li>
                <li>
                    <svg width="800px" height="800px" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <rect width="24" height="24" fill="white"/>
                        <path d="M13 3L16 6L19 9M13 3L5 3L5 21L19 21L19 9M13 3L13 9L19 9" stroke="#000000" stroke-linejoin="round"/>
                    </svg>
                    <span>2 bài viết</span>
                </li>
                <li>
                    <svg width="800px" height="800px" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M2 20V4C2 3.44772 2.44772 3 3 3H8.44792C8.79153 3 9.11108 3.17641 9.29416 3.46719L10.5947 5.53281C10.7778 5.82359 11.0974 6 11.441 6H21C21.5523 6 22 6.44772 22 7V20C22 20.5523 21.5523 21 21 21H3C2.44772 21 2 20.5523 2 20Z" stroke="#200E32" stroke-width="2"/>
                        <path d="M15 14L12 17L9 14" stroke="#200E32" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M12 17L12 10" stroke="#200E32" stroke-width="2" stroke-linecap="round"/>
                    </svg>
                    <span>2 tài nguyên có thể tải xuống</span>
                </li>
                <li>
                    <svg fill="#000000" width="800px" height="800px" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path d="M17,23a2,2,0,0,0,2-2V3a2,2,0,0,0-2-2H7A2,2,0,0,0,5,3V21a2,2,0,0,0,2,2ZM7,3H17V21H7Zm6,16a1,1,0,1,1-1-1A1,1,0,0,1,13,19Z"/></svg>
                    <span>Truy cập trên thiết bị di động và TV</span>
                </li>
                <li>
                    <svg fill="#000000" width="800px" height="800px" viewBox="0 0 24 24" id="infinite-2" data-name="Flat Line" xmlns="http://www.w3.org/2000/svg" class="icon flat-line"><path id="primary" d="M14.84,14.82a3.73,3.73,0,1,0-.2-5.46L9.36,14.64a3.73,3.73,0,1,1-.2-5.46" style="fill: none; stroke: rgb(0, 0, 0); stroke-linecap: round; stroke-linejoin: round; stroke-width: 2;"></path></svg>
                    <span>Quyền truy cập đầy đủ suốt đời</span>
                </li>
                <li>
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M23 12l-2.44-2.78.34-3.68-3.61-.82-1.89-3.18L12 3 8.6 1.54 6.71 4.72l-3.61.81.34 3.68L1 12l2.44 2.78-.34 3.69 3.61.82 1.89 3.18L12 21l3.4 1.46 1.89-3.18 3.61-.82-.34-3.68L23 12zm-10 5h-2v-2h2v2zm0-4h-2V7h2v6z"/></svg>
                    <span>Giấy chứng nhận hoàn thành</span>
                </li>
            </ul>
        </div>
    </div>
  )
}
