import React, { useState } from 'react'
import { Link } from 'react-router-dom'
import { CardInfoDetailCourse } from './CardInfoDetailCourse';
import { RatingComponent } from '../RatingComponent/RatingComponent';

export const CardCourse = ({listCourses}) => {
  const [isOpen, setIsOpen] = useState(false);
  console.log('isOpen', isOpen)
  const handleMouseOver = () => {
    setIsOpen(true);
  };

  const handleMouseLeave = () => {
    setIsOpen(false);
  };
  return (
    <div className='relative grid grid-rows-2 gap-2 justify-items-center' onMouseOver={handleMouseOver} onMouseLeave={handleMouseLeave}>
      <div className='mb-1 max-w-[232.48px] '>
        <img className='aspect-first' src={listCourses?.image} alt="" />
      </div>
      <div>
        <h3 className='mb-1'>
          <Link className='crop-text2'>{listCourses?.title}</Link>
        </h3>
        <span className='text-third text-xs mb-1'>TS. Dang Xuan Tho</span>
        <RatingComponent/>
        <h3 className='mb-1'>₫&nbsp;899.000</h3>
        <div className='mt-2 mb-1 '>
          <span className='bg-[#eceb98] text-xs font-bold px-2 py-1'>Bán chạy nhất</span>
        </div>
      </div>
      
      <CardInfoDetailCourse isOpen={isOpen} handleMouseOver={handleMouseOver} handleMouseLeave={handleMouseLeave}/>
    </div>
  )
}
