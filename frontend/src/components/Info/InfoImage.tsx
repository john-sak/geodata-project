import React from 'react'
import Image from 'next/image'

const InfoImage = () => {
  return (
    <div className='relative w-[100%] h-[50%] flex items-center justify-center
    lg:w-[50%] lg:h-[90%]'
    >
        <Image
        src={require('../../assets/building4.png')}
        alt='image of a building'
        fill
        sizes="(max-width: 768px) 100vw,
              (max-width: 1200px) 50vw,
              33vw"
        className='object-contain'
        priority
        />

    </div>
  )
}

export default InfoImage