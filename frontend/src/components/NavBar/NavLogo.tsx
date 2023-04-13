import Link from 'next/link'
import React from 'react'
import Image from 'next/image'

const NavLogo = () => {
  return (
    <div className="absolute h-20 w-28 flex">
        <Link href={'/'}
        className='h-20 w-28 relative'
        >
            <Image
            src='/logo1.png'
            alt='logo'
            fill
            priority
            sizes='width: 112px'
            />
        </Link>
    </div>
  )
}

export default NavLogo