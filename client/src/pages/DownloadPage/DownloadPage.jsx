import React from 'react'

const DownloadPage = () => {
  return (
    <div className='bg-no-repeat bg-cover z-0' style={{backgroundImage:"url(assets/imgs/bg1.jpg)"}}>
      <div className='max-w-[1340px] p-6 pb-12 mx-auto '>
        <h1 className='mt-6 mb-12 text-center font-times'>Cách học phù hợp với cuộc sống của bạn — trên iOS và Android</h1>
        <ul className='text-2xl mb-8 pl-6 max-w-[484px]'>
          <li className='list-disc '>Xây dựng bộ kỹ năng của bạn với các khóa học video về hơn 3400 chủ đề</li>
          <li className='list-disc mt-1'>Tùy chỉnh trải nghiệm của bạn với tính năng nhắc nhở học tập và chế độ nền tối</li>
          <li className='list-disc mt-1'>Học ở bất cứ đâu với chế độ xem offline, Chromecast và AirPlay</li>
          <li className='list-disc mt-1'>Vừa học vừa làm việc khác nhờ tính năng hình trong hình và âm thanh kiểu podcast</li>
        </ul>
      </div>
    </div>
  )
}

export default DownloadPage