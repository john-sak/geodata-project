import React from 'react'
import { INavLink } from './Inav'
import Link from 'next/link';

const NavLink = (props: INavLink) => {

    const { link, text } = props;

  return (
    <div className='hidden lg:text-base lg:flex lg:justify-center
    lg:items-center lg:h-10: lg:w-20 lg:ml-10 2xl:w-22 2xl:ml-12'>
        {
          link ?
          <Link href={link}>
            {text}
        </Link> :
        <p>
          {text}
        </p>
        }
            
    </div>
  )
}

export default NavLink