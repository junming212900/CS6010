#!/bin/sh
set -e
if test "$CONFIGURATION" = "Debug"; then :
  cd "/Users/junmingjin/MSD/CS6010/myGithubRepo/Finalproject/untitled folder/xcode"
  make -f /Users/junmingjin/MSD/CS6010/myGithubRepo/Finalproject/untitled\ folder/xcode/CMakeScripts/ReRunCMake.make
fi
if test "$CONFIGURATION" = "Release"; then :
  cd "/Users/junmingjin/MSD/CS6010/myGithubRepo/Finalproject/untitled folder/xcode"
  make -f /Users/junmingjin/MSD/CS6010/myGithubRepo/Finalproject/untitled\ folder/xcode/CMakeScripts/ReRunCMake.make
fi
if test "$CONFIGURATION" = "MinSizeRel"; then :
  cd "/Users/junmingjin/MSD/CS6010/myGithubRepo/Finalproject/untitled folder/xcode"
  make -f /Users/junmingjin/MSD/CS6010/myGithubRepo/Finalproject/untitled\ folder/xcode/CMakeScripts/ReRunCMake.make
fi
if test "$CONFIGURATION" = "RelWithDebInfo"; then :
  cd "/Users/junmingjin/MSD/CS6010/myGithubRepo/Finalproject/untitled folder/xcode"
  make -f /Users/junmingjin/MSD/CS6010/myGithubRepo/Finalproject/untitled\ folder/xcode/CMakeScripts/ReRunCMake.make
fi

