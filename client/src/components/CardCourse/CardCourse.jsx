import React from 'react'
import { Link } from 'react-router-dom'
import { Rating } from '@mui/material';
import { Tooltip } from 'flowbite-react';
import { CardInfoDetailCourse } from './CardInfoDetailCourse';

export const CardCourse = ({listCourses}) => {
  return (
    <Tooltip content={<CardInfoDetailCourse/>} placement="right">
      <div className='grid grid-rows-2 gap-2 justify-items-center'>
        <div className='mb-1 max-w-[232.48px] '>
          <img className='aspect-first' src={listCourses?.image} alt="" />
        </div>
        <div>
          <h3 className='mb-1'>
            <Link className='crop-text2'>{listCourses?.title}</Link>
          </h3>
          <span className='text-third text-xs mb-1'>TS. Dang Xuan Tho</span>
          <div className='flex items-center'>
            <span className='text-base font-bold'>4,6</span>
            <Rating
            className='mx-1'
            sx={{
              '& .MuiRating-iconFilled': {
                color: '#b4690e',
              },
              '& .MuiRating-icon': {
                fontSize: '14px',
              },
            }} 
            name="half-rating"
            readOnly
            defaultValue={2.5} 
            precision={0.5} 
            />
            <span className='text-third mb-1'>(50)</span>
          </div>
          <h3 className='mb-1'>₫&nbsp;899.000</h3>
          <div className='mt-2 mb-1 '>
            <span className='bg-[#eceb98] text-xs font-bold px-2 py-1'>Bán chạy nhất</span>
          </div>
        </div>
      </div>
    </Tooltip>
  )
}
