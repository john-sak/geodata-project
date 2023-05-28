import Link from 'next/link'
import React from 'react'

const HeroCTA = () => {
  return (
    <div className='mt-[50px] flex items-center justify-center'>
        <Link href={'/search'}
        className='rounded flex justify-center items-center text-center h-12 w-28 bg-amber-700 hover:bg-amber-600
        text-white text-lg'
        >
            Συνέχεια
        </Link>
    </div>
  )
}

export default HeroCTA