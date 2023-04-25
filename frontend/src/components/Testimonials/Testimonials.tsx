import React from 'react'
import TestimonialsTitle from './TestimonialsTitle'
import TestimonialsSubtitle from './TestimonialsSubtitle'
import { dummyData } from './data'
import Testimonial from './Testimonial'

const Testimonials = () => {
  return (
    <div className='w-[100%] h-[450px] bg-sky-200 lg:h-[400px]'>
        <div className='w-[100%] flex flex-col items-center gap-7'>
            <TestimonialsTitle/>
            <TestimonialsSubtitle/>
        </div>
        <div className='flex justify-around flex-wrap flex-col items-center mt-10 lg:mt-14'>
            <div className='w-[90%] h-[100%] flex flex-wrap gap-4 justify-around'>
                {
                    dummyData.map((value) => {
                        return(
                            <Testimonial 
                            key={value.id} 
                            {...value}
                            />
                        )
                    })
                }
            </div>
            
        </div>
    </div>
  )
}

export default Testimonials