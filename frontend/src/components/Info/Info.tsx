import React from 'react'
import InfoTitle from './InfoTitle'
import InfoSubtitle from './InfoSubtitle'
import InfoImage from './InfoImage'
import InfoButton from './InfoButton'

const Info = () => {
  return (
    <div className='w-[100%] h-[650px] bg-sky-700 flex flex-col lg:flex-row lg:items-center lg:h-[500px]'>
        <div className='w-[100%] h-[50%] flex flex-col items-center gap-7
        lg:w-[50%] lg:order-2 lg:h-[100%]'>
            <InfoTitle/>
            <InfoSubtitle/>
            <InfoButton/>
        </div>
        <InfoImage/>
    </div>
  )
}

export default Info