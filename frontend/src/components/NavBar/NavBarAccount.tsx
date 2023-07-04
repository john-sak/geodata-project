import React, { useState } from 'react'
import Link from 'next/link';
import AccountBoxIcon from '@mui/icons-material/AccountBox';
import useLogged from './useLogged';
import { useRouter } from 'next/router';
import useCloseModal from '@/hooks/useCloseModal';

const NavBarAccount = () => {

    const [open, setOpen] = useState(false);

    const { setIsLogged } = useLogged();

    const router = useRouter();

    const handleLogout = () => {
        localStorage.clear();
        setIsLogged(false);
        setOpen(!open);
        router.replace('/');
    }

    let ref = useCloseModal(() => {
        if(open) {
            setOpen(false);
        }
    });

  return (
    <div 
    className='hidden lg:flex lg:absolute lg:right-0 lg:w-60 lg:h-20
    lg:justify-center lg:flex-col lg:items-center 2xl:w-80'
    >
        <div ref={ref} className='flex flex-col items-center'>
            <i
            className='text-white cursor-pointer'
            >
                <AccountBoxIcon 
                fontSize='large' 
                className='scale-110'
                onClick={() => setOpen(!open)}
                />
            </i>
            <p
            className='text-white'
            >
                Λογαριασμός
            </p>
            {
                open &&
                    <div
                    className='rounded h-28 w-40 absolute top-11 bg-slate-300 flex flex-col'
                    >
                        <Link href={'/ProfilePage'}
                        className='h-[50%] flex items-center justify-center underline text-sky-700'
                        onClick={() => setOpen(!open)}
                        >
                            Προφίλ
                        </Link>
                        <p
                        className='h-[50%] flex items-center justify-center underline text-sky-700 cursor-pointer'
                        onClick={handleLogout}
                        >
                            Αποσύνδεση
                        </p>
                    </div>
            }
        </div>
    </div>
  )
}

export default NavBarAccount