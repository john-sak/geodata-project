import React from 'react'
import { INavMenu } from './Inav';
import Link from 'next/link';
import useCloseModal from '@/hooks/useCloseModal';

const NavMenu = (props: INavMenu) => {

    const { open, setOpen } = props;

    let ref = useCloseModal(() => setOpen(!open))

  return (
    <div className='absolute top-0 right-0 w-44 h-[260px] bg-slate-300 rounded z-9'
    ref={ref}
    >
        <div className='absolute top-[70px] h-[160px] w-44'>
            <div className='h-10 flex justify-center items-center'>
                <Link href={'/search'}
                className='underline text-sky-700'
                onClick={() => setOpen(!open)}
                >
                    Εφαρμογή
                </Link>
            </div>
            <div className='h-10 flex justify-center items-center'>
                <Link href={'/DummyPage'}
                onClick={() => setOpen(!open)}
                className='underline text-sky-700'
                >
                    Δεδομένα
                </Link>
            </div>
            <div className='h-10 flex justify-center items-center'>
                <Link href={'/SigninPage'}
                onClick={() => setOpen(!open)}
                className='underline text-sky-700'
                >
                    Σύνδεση
                </Link>
            </div>
            <div className='h-10 flex justify-center items-center'>
                <Link href={'/SignupPage'}
                onClick={() => setOpen(!open)}
                className='underline text-sky-700'
                >
                    Εγγραφή
                </Link>
            </div>
        </div>
    </div>
  )
}

export default NavMenu