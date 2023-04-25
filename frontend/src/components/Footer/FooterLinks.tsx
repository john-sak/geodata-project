import Link from 'next/link'
import React from 'react'

const FooterLinks = () => {
  return (
    <div className='w-[100%] h-10 flex justify-between mt-6'>
        <Link
        href={'https://geodata.gov.gr/el/'}
        className='w-[40%] text-sm text-center lg:text-base'
        rel="noopener noreferrer" target="_blank"
        >
            Geodata Gov
        </Link>
        <p className='w-[40%] text-sm text-center lg:text-base'>
            Πολιτική Cookies
        </p>
    </div>
  )
}

export default FooterLinks