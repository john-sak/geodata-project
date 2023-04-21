import React from 'react'
import InfoTitle from './InfoTitle'
import InfoSubtitle from './InfoSubtitle'
import InfoImage from './InfoImage'

const Info = () => {
  return (
    <div className='w-[100%] h-[500px] bg-sky-700 flex flex-col lg:flex-row lg:items-center'>
        <div className='w-[100%] h-[50%] flex flex-col items-center gap-7
        lg:w-[50%] lg:order-2 lg:h-[100%]'>
            <InfoTitle/>
            <InfoSubtitle/>
        </div>
        <InfoImage/>
    </div>
  )
}

export default Info