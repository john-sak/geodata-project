import React from 'react'
import HeroTitle from './HeroTitle'
import HeroSubtitle from './HeroSubtitle'
import HeroCTA from './HeroCTA'

const Hero = () => {
  return (
    <div className="h-[500px] w-[100%] z-0 mt-[-80px]
    bg-sky-800 bg-blend-multiply bg-[url('../assets/image1.jpg')] bg-cover
    flex flex-col">
      <div className='lg:w-[40%]'>
        <HeroTitle/>
        <HeroSubtitle/>
        <HeroCTA/>
      </div>
    </div>
  )
}

export default Hero