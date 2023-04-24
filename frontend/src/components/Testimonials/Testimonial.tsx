import React from 'react'
import { ITestimonial } from './ITestimonial'

const Testimonial = (props: ITestimonial) => {

    const { title, count } = props;

  return (
    <div className='rounded-full h-24 w-24 shadow-lg backdrop-blur-sm bg-white/30  shadow-amber-700 outline-double outline-amber-700
    flex justify-center lg:h-32 lg:w-32 xl:h-36 xl:w-36'>
        <div className='mt-4 flex flex-col'>
            <p className='text-sm text-center lg:text-base lg:mt-1 xl:mt-3'>
                {count}
            </p>
            <p className='text-sm mt-4 text-center lg:text-base lg:mt-6'>
                {title}
            </p>
        </div>
    </div>
  )
}

export default Testimonial