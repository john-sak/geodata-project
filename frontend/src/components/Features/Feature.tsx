import React from 'react'
import { IFeature } from './IFeatures'
import Image from 'next/image';

const Feature = (props: IFeature) => {

    const {
        title,
        subtitle,
        image,
        imageAlt
    } = props;

  return (
    <div className='w-[100%] h-[220px] flex items-center justify-center flex-col gap-7
    lg:w-[30%] lg:h-[300px] xl:w-[25%]'>
        <div className='w-[100%] flex justify-center mt-2'>
            <Image
            src={require(`../../assets/${image}`)}
            alt={imageAlt}
            priority
            className='w-14 h-14'
            />
        </div>
        <div className='w-[100%] flex justify-center'>
            <h3 className='text-xl text-center'>
                {title}
            </h3>
        </div>
        <div className='w-[100%] flex justify-center'>
            <p className='text-base text-center w-[80%]'>
                {subtitle}
            </p>
        </div>
    </div>
  )
}

export default Feature