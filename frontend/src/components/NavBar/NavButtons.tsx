import Link from 'next/link'
import React from 'react'

const NavButtons = () => {
  return (
    <div className='hidden lg:flex lg:absolute lg:right-0 lg:w-60 lg:h-20 lg:justify-start
    lg:gap-7 lg:items-center 2xl:w-80 2xl:gap-10'>
        <Link href={'SigninPage'}
        className='flex justify-center items-center lg:w-24 lg:h-9 2xl:w-28 2xl:h-10 
        rounded bg-sky-900 hover:bg-sky-400 cursor-pointer'
        >
            Σύνδεση
        </Link>
        <Link href={'SignupPage'}
        className='flex justify-center items-center lg:w-24 lg:h-9 2xl:w-28 2xl:h-10 \
        rounded bg-orange-500 hover:bg-orange-400 cursor-pointer'
        >
            Εγγραφή
        </Link>
    </div>
  )
}

export default NavButtons