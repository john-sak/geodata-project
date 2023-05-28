import Link from 'next/link'
import React from 'react'

const InfoButton = () => {
  return (
    <div className='w-[100%] mt-1 flex justify-center lg:justify-start lg:mt-4'>
        <div className='lg:w-[95%] lg:flex lg:justify-end'>
            <Link href={'/SignupPage'}
            className='rounded flex justify-center items-center text-center h-14 w-36 bg-amber-700 hover:bg-amber-600
            text-white text-base'
            >
                Δημιουργία <br/> Λογαριασμού
            </Link>
        </div>
    </div>
  )
}

export default InfoButton