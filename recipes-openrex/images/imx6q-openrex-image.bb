SUMMARY = "A console-only image that fully supports the target device hardware."

IMAGE_FEATURES:append = " splash"

LICENSE = "MIT"

inherit core-image

GROUPADD_PARAM:${PN} = " bluetooth"
IMAGE_FEATURES:append:openrex-imx6quad = " read-only-rootfs"
IMAGE_FEATURES:append:openrex-imx6quad = " splash"
IMAGE_FEATURES:append:openrex-imx6quad = " tools-profile"
IMAGE_FEATURES:append:openrex-imx6quad = " ssh-server-dropbear"
IMAGE_INSTALL:append:openrex-imx6quad = " gdbserver"
IMAGE_INSTALL:append:openrex-imx6quad = " gdb"
IMAGE_INSTALL:append:openrex-imx6quad = " nano"
IMAGE_INSTALL:append:openrex-imx6quad = " vim"
