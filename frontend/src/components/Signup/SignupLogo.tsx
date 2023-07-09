import React from 'react'
import Image from 'next/image'
import Link from 'next/link'

const SignupLogo = () => {
  return (
    <div className='w-[100%] flex justify-center items-center'>
        <Link href={'/'}
        className='h-20 w-20 relative'
        >
            <Image
            src='/logo1.png'
            alt='logo'
            fill
            sizes='width: 112px'
            placeholder='blur'
            blurDataURL='/logo1.png'
            />
        </Link>
        <h3 className='text-3xl font-bold'>
            Crowd Critic
        </h3>
    </div>
  )
}

export default SignupLogo