# Copyright (C) 2023 kamelghalgaoui7@gmail.com
# Based on u-boot-fslc.inc Copyright (C) 2020-2022 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)
 
require recipes-bsp/u-boot/u-boot.inc
inherit fsl-u-boot-localversion
 
DEPENDS_mxs += "elftosb-native openssl-native"
DEPENDS:append = "bison-native"

SUMMARY = "U-Boot bootloader with support for OpenRex board"
DESCRIPTION = "U-Boot bootloader with support for OpenRex board. More info \
at http://www.imx6rex.com/open-rex"
 
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=5a7450c57ffe5ae63fd732446b988025"
 
COMPATIBLE_MACHINE = "(mx6|openrex-imx6quad)"
 
PROVIDES += "u-boot"
 
PV = "v2022.04+git${SRCPV}"

SRCBRANCH ??= "kirkstone"
 
SRC_URI = "git://github.com/Ghalgaoui/openrex-uboot-v2022.04.git;protocol=https;branch=${SRCBRANCH}"

#SRCREV is the commit number, must be always changed for a new version
SRCREV = "48d992d0fd6ad6ca663c45a72d213bca9ac9727b"
 
S = "${WORKDIR}/git"
 
# FIXME: Allow linking of 'tools' binaries with native libraries
#        used for generating the boot logo and other tools used
#        during the build process.
EXTRA_OEMAKE += 'HOSTCC="${BUILD_CC} ${BUILD_CPPFLAGS}" \
                 HOSTLDFLAGS="${BUILD_LDFLAGS}" \
                 HOSTSTRIP=true'
 
PACKAGE_ARCH = "${MACHINE_ARCH}"
