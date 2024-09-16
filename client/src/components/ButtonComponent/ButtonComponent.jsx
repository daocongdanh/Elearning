import React from 'react'

export const ButtonComponent = ({text,icon,textColor,colorBoder,colorBg,bold,padding,hover,height,fullScreen,width}) => {
  return (
      <button className={`${fullScreen?`w-full`:""} ${width?width:""} flex items-center justify-center border ${bold?`font-bold`:""} ${colorBg?`bg-${colorBg}`:""} ${colorBoder?`border-${colorBoder}`:"border-first"} ${textColor?`text-${textColor}`:"text-black"} px-${padding?padding:"4"} ${height?height:"h-10"} ${hover?"hover:bg-[#1739531f]":"hover:bg-[#3e4143]"}`}>
          {icon}
          <span className='tablet:text-base'>
            {text?text:""}
          </span>
      </button>
  )
}   
